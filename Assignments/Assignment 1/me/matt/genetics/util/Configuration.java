package me.matt.genetics.util;

public class Configuration {

    /**
     * The percentage representing how often a crossover has a mutation (must be greater than 1)
     */
    public final static int MUTATION_RATE = 80;
    
    /**
     *  The maximum dimension that the gui will populate (i.e. 50 = 50x50 or 2500 checkboxes so, 100x100 = 100,000 checkboxes) 
     */
    public final static int MAX_GUI_SIZE = 50;
    
    /**
     *  Artifically slow down the program so the user can see the evolutions occuring
     */
    public final static boolean ARTIFICALLY_SLOW_DOWN = true;

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
