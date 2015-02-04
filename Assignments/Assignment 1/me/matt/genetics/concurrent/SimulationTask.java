package me.matt.genetics.concurrent;

import java.util.concurrent.Callable;

import me.matt.genetics.util.Configuration;
import me.matt.genetics.wrapper.Population;

/** Try to ping a URL. Return true only if successful. */
public class SimulationTask implements Callable<Population> {

    private final int generations;
    private long evolutions;
    private Population population;
    private final int size;
    private final int dimension;
    private final int test;

    SimulationTask(final int generations, final int size, final int dimension,
            int test) {
        this.generations = generations;
        this.size = size;
        this.dimension = dimension;
        this.test = test;
    }

    @Override
    public Population call() throws Exception {
        if (Configuration.DEBUG) {
            System.out.println("Thread " + test + " started.");
        }
        population = new Population(size, dimension);
        if (Configuration.DEBUG) {
            System.out.println("Thread " + test + " populated.");
        }
        while (!Thread.currentThread().isInterrupted() && dimension > 3) {
            if (evolutions == generations) {
                break;
            }
            if (population.getFittest().getFitness() == 0) {
                break;
            }
            population.evolve();
            if (Configuration.DEBUG) {
                System.out.println("Thread " + test + " generation "
                        + evolutions + " fittest "
                        + population.getFittest().getFitness());
            }
            evolutions++;
        }
        if (Configuration.DEBUG) {
            if (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread " + test + " complete");
            }
        }
        return population;
    }
}