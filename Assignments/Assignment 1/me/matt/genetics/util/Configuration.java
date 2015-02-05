package me.matt.genetics.util;

public class Configuration {

    /**
     * The percentage representing how often a crossover has a mutation
     */
    public final static int MUTATION_RATE = 80;

    /**
     * Should the program try to find muliple solutions in parallel
     */
    public final static boolean MULTI_THREADED = false;

    /**
     * How many threads should the parallel solution run on
     */
    public final static int THREAD_COUNT = 4;

    /**
     * Should debug messages be printed to the console
     */
    public final static boolean DEBUG = false;

}
