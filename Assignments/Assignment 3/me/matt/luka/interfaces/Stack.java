package me.matt.luka.interfaces;

/**
 * Stack Abstract Data Type. A Stack is a linear data structure following
 * last-in-first-out protocol, i.e. the last element that has been added onto
 * the Stack, is the first one to be removed.
 *
 * @author Marcel Turcotte
 *         <ul>
 *         <li>Classname: Stack.java
 *         <li>23-03-2015
 *         <li>Assignment 3
 *         <li>Course: IT1 1121 A
 *         <li>Langlois, Matt
 *         <li>Student number: 7731813
 *         <li>Faubert, Joel
 *         <li>Student number: 2560106
 *         </ul>
 *
 * @author Matt Langlois
 * @author Joel Faubert
 * @version 1
 *
 */
public interface Stack<E> {

    /**
     * Tests if this Stack is empty.
     *
     * @return true if this Stack is empty; and false otherwise.
     */
    public abstract boolean isEmpty();

    /**
     * Returns a reference to the top element; does not change the state of this
     * Stack.
     *
     * @return The top element of this stack without removing it.
     */
    public abstract E peek();

    /**
     * Returns a refrence to the element at the specified distance into the stack
     *
     * @param distance
     *            The distance into the stack you wish to peek
     *
     * @return The top element of this stack without removing it.
     */
    public abstract E peek(int distance);

    /**
     * Removes and returns the element at the top of this stack.
     *
     * @return The top element of this stack.
     */
    public abstract E pop();

    /**
     * Puts an element onto the top of this stack.
     *
     * @param element
     *            the element be put onto the top of this stack.
     */
    public abstract void push(E element);

    /**
     * Returns the number of elements in the stack.
     *
     * @return The number of elements in the stack
     */
    public abstract int size();

}
