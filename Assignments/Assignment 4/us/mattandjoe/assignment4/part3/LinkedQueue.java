package us.mattandjoe.assignment4.part3;

/**
 * ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Linked node implementation of queue data type
 *
 * @author Marcel Turcotte
 *
 *         <ul>
 *         <li>Classname: LinkedQueue.java
 *         <li>31-03-2015
 *         <li>Assignment 4
 *         <li>Course: IT1 1121 A
 *         <li>Langlois, Matt
 *         <li>Student number: 7731813
 *         <li>Faubert, Joel
 *         <li>Student number: 2560106
 *         </ul>
 */

public class LinkedQueue<E> implements Queue<E> {

    private static class Elem<E> {

        private final E value;
        private Elem<E> next;

        private Elem(final E value, final Elem<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem<E> front;
    private Elem<E> rear;

    /**
     * Default constructor
     */
    public LinkedQueue() {
        front = rear = null;
    }

    /**
     * Returns the element at the front of the queue, if any
     *
     * @throws EmptyQueueException
     *             if method is called when queue is empty
     */
    @Override
    public E dequeue() {

        // pre-conditions:

        if (front == null) {
            throw new EmptyQueueException();
        }

        final E result = front.value;

        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
        }

        return result;
    }

    /**
     * Add an element to the back of the queue
     *
     * @param E
     *            object to add to the queue
     * @throws IllegalArgumentException
     *             when attempting to enqueue null
     */
    @Override
    public void enqueue(final E o) {

        // pre-conditions:

        if (o == null) {
            throw new IllegalArgumentException("null");
        }

        Elem<E> newElem;
        newElem = new Elem<E>(o, null);

        if (rear == null) {
            front = rear = newElem;
        } else {
            rear.next = newElem;
            rear = rear.next;
        }

    }

    /**
     * Returns true if queue is empty.
     */
    @Override
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Returns reference to object at the front of the queue without dequeueing
     */
    @Override
    public E peek() {

        // pre-conditions:

        if (front == null) {
            throw new EmptyQueueException();
        }

        return front.value;
    }

}
