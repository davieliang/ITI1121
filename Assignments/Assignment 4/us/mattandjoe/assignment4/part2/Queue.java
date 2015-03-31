package us.mattandjoe.assignment4.part2;

/** ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Queue Abstract Data Type. A Queue is a linear data structure
 * following first-in-first-out protocol, i.e. the first element that
 * has been added to the Queue, is the first one to be removed.
 *
 * @author Marcel Turcotte
 * @param <E>
 *            the type of elements in this queue
 * 
 * <ul>
 * <li>Classname: Queue.java
 * <li>31-03-2015
 * <li>Assignment 4
 * <li>Course: IT1 1121 A
 * <li>Langlois, Matt
 * <li>Student number: 7731813
 * <li>Faubert, Joel
 * <li>Student number: 2560106
 * </ul>
 */
public interface Queue<E> {

    /**
     * Removes and returns the front element of the Queue.
     *
     * @return the front element of the Queue.
     */

    public abstract E dequeue();

    /**
     * Puts an element at the rear of this Queue.
     *
     * @param element
     *            the element be put at the rear of this Queue.
     */

    public abstract void enqueue(E element);

    /**
     * Tests if this Queue is empty.
     *
     * @return true if this Queue is empty; and false otherwise.
     */

    public abstract boolean isEmpty();

}