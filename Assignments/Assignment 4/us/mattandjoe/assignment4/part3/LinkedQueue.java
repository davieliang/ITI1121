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

        private E value;
        private Elem<E> next;

        private Elem(E value, Elem<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem<E> front;
    private Elem<E> rear;

    public LinkedQueue() {
        front = rear = null;
    }

    public E peek() {

        // pre-conditions:

        if (front == null) {
            throw new EmptyQueueException();
        }

        return front.value;
    }

    public void enqueue(E o) {

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

    public E dequeue() {

        // pre-conditions:

        if (front == null) {
            throw new EmptyQueueException();
        }

        E result = front.value;

        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
        }

        return result;
    }

    public boolean isEmpty() {
        return front == null;
    }

}
