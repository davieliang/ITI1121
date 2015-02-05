package me.matt.genetics.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.matt.genetics.wrapper.Individual;

/**
 * Provides a method returning a random permutation of the numbers 0 to <code>n-1</code>, where <code>n</code> is the size of the permutation.
 *
 * @author Marcel Turcotte
 * @version 2015/01/24
 */

public class Util {

    /**
     * Returns a randomly generated permutation of the numbers 0 to <code>n-1</code>, where <code>n</code> is the size of the permutation. The
     * permutation of size 0 is an empty permutation, which corresponds to an array of size 0.
     *
     * @param n
     *            is the size of the permutation
     * @return an array of size <code>n</code> containing the numbers 0 to <code>n-1</code> in random order
     */

    public static int[] getPermutation(final int n) {

        // precondition: n >=0

        int permutation[];
        permutation = new int[n];

        boolean used[]; // memorizes the values that have already been used
        used = new boolean[n];

        int position = 0;
        while (position < n) { // stops when all the positions have been filled
            final int index = Util.random.nextInt(n);
            if (!used[index]) {
                permutation[position] = index;
                used[index] = true;
                position++; // incremented only if an unused value has been found
            }
        }
        return permutation;
    }

    /**
     * Return a formatted string with the running time of the program.
     *
     * @param starttime
     *            The time the program began {@link java.lang.System#currentTimeMillis()}
     * @return The running time of the program formatted to "DD:MM:HH:SS.ms"
     */
    public static String getRuntime(final long starttime) {
        try {
            long millis = System.currentTimeMillis() - starttime;
            final long days = millis / (1000 * 60 * 60 * 24);
            millis -= days * (1000 * 60 * 60 * 24);
            final long hours = millis / (1000 * 60 * 60);
            millis -= hours * (1000 * 60 * 60);
            final long minutes = millis / (1000 * 60);
            millis -= minutes * (1000 * 60);
            final long seconds = millis / 1000;
            millis -= seconds * 1000;
            return days + ":" + hours + ":" + minutes + ":" + seconds + "."
                    + millis + " seconds";
        } catch (final Exception e) {
            return "0:0:0:0.0";
        }
    }

    /**
     * Returns a linearly distributed pseudorandom integer.
     *
     * @param min
     *            The inclusive lower bound.
     * @param max
     *            The exclusive upper bound.
     * @return Random integer min <= n < max.
     */
    public static int random(final int min, final int max) {
        return min + (max == min ? 0 : Util.random.nextInt(max - min));
    }

    // Create an array with all unique elements
    public static Individual[] removeDuplicates(final Individual[] individuals) {
        final List<Individual> cleaned = new ArrayList<Individual>();
        for (final Individual individual : individuals) {
            if (!cleaned.contains(individual)) {
                cleaned.add(individual);
            }
        }
        return cleaned.toArray(new Individual[cleaned.size()]);
    }

    /** Uses a a generator of pseudo-random numbers */

    private static final Random random = new Random();

    public static boolean allEqual(Individual[] individuals) {
        for (int i = 1; i < individuals.length; i++) {
            if (!individuals[i - 1].equals(individuals[i])) {
                return false;
            }
        }
        return true;
    }
}
