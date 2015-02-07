package me.matt.genetics.concurrent;

import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.SwingWorker;

import me.matt.genetics.MessageType;
import me.matt.genetics.gui.FitnessGUI;
import me.matt.genetics.util.Configuration;
import me.matt.genetics.util.Util;
import me.matt.genetics.wrapper.Individual;
import me.matt.genetics.wrapper.Population;
import me.matt.genetics.wrapper.exception.EvolveException;

public class Simulation extends SwingWorker<Void, Individual> {

    private final int generations;
    private final boolean displayGUI;
    private long evolutions;
    private final long startTime;
    private Population population;
    private final FitnessGUI gui;
    private final int size;
    private final int dimension;

    public Simulation(final int generations, final int size,
            final int dimension, final boolean displayGUI) throws Exception {
        this.generations = generations;
        this.size = size;
        this.dimension = dimension;
        this.displayGUI = displayGUI;
        startTime = System.currentTimeMillis();
        gui = displayGUI ? new FitnessGUI(dimension, true,
                generations > 0 ? generations : -1) : null;
        evolutions = 0;
    }

    @Override
    protected Void doInBackground() throws Exception {
        if (displayGUI && gui != null) {
            this.runSimulation();
        } else {
            if (Configuration.MULTI_THREADED) {
                System.out.println("Running tasks concurrently");
                this.runSimulationInParallel();
            } else {
                this.runSimulation();
            }

        }
        return null;
    }

    @Override
    protected void done() {
        if (dimension > 3) {
            if (population != null) {
                population.finalize();
                final String result = "Execution time taken: "
                        + Util.getRuntime(startTime) + System.lineSeparator()
                        + "Generations: " + evolutions + System.lineSeparator()
                        + "Population Size: " + size + System.lineSeparator()
                        + "Dimension: " + dimension + System.lineSeparator()
                        + "Attributes: " + population.getFittest().toString();
                if (displayGUI && gui != null) {
                    gui.finalize(population, result);
                } else {
                    System.out.println(result);
                    System.exit(0);
                }
            } else {
                if (displayGUI && gui != null) {
                    gui.log("There has been an error creating the population!",
                            MessageType.ERROR);
                } else {
                    System.out
                            .println("There has been an error creating the population!");
                    System.exit(0);
                }
            }
        }
    }

    @Override
    public void process(final List<Individual> list) {
        final String update = "There have been " + evolutions
                + " generations and the fittest individual is "
                + population.getFittest().getFitness() + ".";
        if (gui != null && displayGUI) {
            gui.update(list.get(list.size() - 1), generations > 0 ? evolutions
                    : list.get(list.size() - 1).getFitness());
            if (Configuration.DEBUG) {
                gui.log(update, MessageType.INFO);
            }
        }
        System.out.println(update);
    }

    public void runSimulation() throws Exception {
        if (displayGUI || !Configuration.MULTI_THREADED) {
            population = new Population(size, dimension);
        }
        gui.setTarget(population.getFittest().getFitness());
        if (gui != null) {
            gui.log("Simulating. Dimension: " + dimension
                    + " Population Size: " + population.getSize(),
                    MessageType.INFO);
            if (Configuration.ARTIFICALLY_SLOW_DOWN && generations > 0) {
                gui.log("The simulation has artifically been slowed down for viewer use!",
                        MessageType.WARNING);
            }
        } else {
            System.out.println("Simulating. Dimension: " + dimension
                    + " Population Size: " + population.getSize());
        }
        while (dimension > 3 && !this.isCancelled()) {
            this.publish(population.getFittest());
            if (evolutions == generations) {
                break;
            }
            if (population.getFittest().getFitness() == 0) {
                break;
            }

            try {
                population.evolve();
            } catch (final EvolveException e) {
                if (displayGUI) {
                    gui.log(e.getMessage(), MessageType.ERROR);
                } else {
                    System.out.println(e.getMessage());
                }
                this.cancel(true);
            }
            evolutions++;
            if (displayGUI && generations > 0
                    && Configuration.ARTIFICALLY_SLOW_DOWN) {
                Thread.sleep(20);
            }
        }
    }

    private void runSimulationInParallel() throws InterruptedException,
            ExecutionException {
        final ExecutorService executor = Executors
                .newFixedThreadPool(Configuration.THREAD_COUNT);
        final CompletionService<Population> service = new ExecutorCompletionService<Population>(
                executor);
        for (int i = 0; i < Configuration.THREAD_COUNT; i++) {
            service.submit(new SimulationTask(generations, size, dimension, i));
        }
        population = service.take().get();
        executor.shutdownNow();
    }
}
