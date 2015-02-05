package me.matt.genetics.concurrent;

import java.util.concurrent.Callable;

import me.matt.genetics.util.Configuration;
import me.matt.genetics.wrapper.Population;
import me.matt.genetics.wrapper.exception.EvolveException;

/** Try to ping a URL. Return true only if successful. */
public class SimulationTask implements Callable<Population> {

    private final int generations;
    private long evolutions;
    private Population population;
    private final int size;
    private final int dimension;
    private final int thread;

    SimulationTask(final int generations, final int size, final int dimension,
            final int thread) {
        this.generations = generations;
        this.size = size;
        this.dimension = dimension;
        this.thread = thread;
    }

    @Override
    public Population call() throws Exception {
        if (Configuration.DEBUG) {
            System.out.println("Thread " + thread + " started.");
        }
        population = new Population(size, dimension);
        if (Configuration.DEBUG) {
            System.out.println("Thread " + thread + " populated.");
        }
        while (!Thread.currentThread().isInterrupted() && dimension > 3) {
            if (evolutions == generations) {
                break;
            }
            if (population.getFittest().getFitness() == 0) {
                break;
            }

            try {
                population.evolve();
            } catch (final EvolveException e) {
                System.out
                        .println("It is impossible for the population to evolve any futher.");
                Thread.currentThread().interrupt();
            }
            if (Configuration.DEBUG) {
                System.out.println("Thread " + thread + " generation "
                        + evolutions + " fittest "
                        + population.getFittest().getFitness());
            }
            evolutions++;
        }
        if (Configuration.DEBUG) {
            if (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread " + thread + " complete");
            }
        }
        return population;
    }
}