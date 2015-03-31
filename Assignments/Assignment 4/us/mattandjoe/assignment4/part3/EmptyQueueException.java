package us.mattandjoe.assignment4.part3;

/** 
 * Specific exception to handle empty queue errors
 * 
 * @author Marcel Turcotte
 * 
 * <ul>
 * <li>Classname: EmptyQueueException.java
 * <li>31-03-2015
 * <li>Assignment 4
 * <li>Course: IT1 1121 A
 * <li>Langlois, Matt
 * <li>Student number: 7731813
 * <li>Faubert, Joel
 * <li>Student number: 2560106
 * </ul>
 */
public class EmptyQueueException extends RuntimeException {

    public EmptyQueueException() {
    }

    public EmptyQueueException( String message ) {
        super( message );
    }
}
