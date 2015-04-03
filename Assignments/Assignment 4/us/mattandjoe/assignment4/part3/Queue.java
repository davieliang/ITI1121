package us.mattandjoe.assignment4.part3;

/**
 * ITI 1121/1521. Introduction to Computer Science II
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
 *            <ul>
 *            <li>Classname: Queue.java
 *            <li>31-03-2015
 *            <li>Assignment 4
 *            <li>Course: IT1 1121 A
 *            <li>Langlois, Matt
 *            <li>Student number: 7731813
 *            <li>Faubert, Joel
 *            <li>Student number: 2560106
 *            </ul>
 */
public interface Queue<E> {

    /**
     * Remove and returns the front element of this Queue.
     *
     * @return the front element of this Queue.
     */

    public abstract E dequeue() throws EmptyQueueException;

    /**
     * Add an element at the rear of this Queue.
     *
     * @throws FullQueueException
     *             if this queue is full.
     */

    public abstract void enqueue(E o);

    /**
     * Returns true if this Queue has no elements.
     *
     * @return true if this Queue has no elements.
     */

    public abstract boolean isEmpty();

    /**
     * Returns a reference to the front element; does not change
     * the state of this Queue.
     *
     * @return The front element of this queue without removing it.
     */

    public abstract E peek() throws EmptyQueueException;
}
