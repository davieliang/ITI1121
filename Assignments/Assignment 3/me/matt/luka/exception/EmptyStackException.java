package me.matt.luka.exception;

/**
 * An object of the class <code>EmptyStackException</code> is thrown by the
 * methods of a <code>Stack</code> to indicate the illegal situations where a
 * stack was empty.
 * <ul>
 * <li>Classname: Application.java
 * <li>23-03-2015
 * <li>Assignment 3
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

public class EmptyStackException extends RuntimeException {

    private static final long serialVersionUID = 831138896625089171L;

    /**
     * Class constructor
     */
    public EmptyStackException() {
    }

    /**
     * Constructor with message
     *
     * @param message
     *            Description of cause of exception
     */
    public EmptyStackException(final String message) {
        super(message);
    }

}
