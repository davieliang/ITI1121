package us.mattandjoe.assignment4.part2;

/**
 * An object of the class <code>EmptyQueueException</code> is thrown
 * by the methods of a <code>Queue</code> to indicate the illegal
 * situations where a queue was empty.
 *
 * @author Marcel Turcotte, Universite d'Ottawa/University of Ottawa
 *
 *         <ul>
 *         <li>Classname: EmptyQueueException.java
 *         <li>31-03-2015
 *         <li>Assignment 4
 *         <li>Course: IT1 1121 A
 *         <li>Langlois, Matt
 *         <li>Student number: 7731813
 *         <li>Faubert, Joel
 *         <li>Student number: 2560106
 *         </ul>
 */
public class EmptyQueueException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    /**
     * Default constructor
     */
    public EmptyQueueException() {
    }

    /**
     * Constructor with message option
     * @param message description of situation causing error
     */
    public EmptyQueueException(final String message) {
        super(message);
    }
}