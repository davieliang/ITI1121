package us.mattandjoe.assignment4.part4;

/**
 * A tuple wrapper class to be used in the frequency test
 *
 * <ul>
 * <li>22-03-2015
 * <li>Assignment 4
 * <li>Course: IT1 1121 A
 * <li>Langlois, Matt
 * <li>Student number: 7731813
 * <li>Faubert, Joel
 * <li>Student number: 2560106
 * </ul>
 *
 * @author Matt Langlois
 * @author Joel Faubert
 * @version 1
 *
 */
public class Tuple {

    private final char c;
    private boolean visited;

    public Tuple(final char c) {
        this.c = c;
        visited = false;
    }

    public char getChar() {
        return c;
    }

    public void toggle() {
        visited = !visited;
    }

    @Override
    public String toString() {
        if (visited) {
            return "(" + c + ",t)";
        } else {
            return "(" + c + ",f)";
        }
    }

    public boolean visited() {
        return visited;
    }
}
