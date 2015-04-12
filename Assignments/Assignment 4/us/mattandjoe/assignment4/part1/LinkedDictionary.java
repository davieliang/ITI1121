/**
 *
 */
package us.mattandjoe.assignment4.part1;

import java.util.NoSuchElementException;

/**
 * Linked list implementation of a map which which stores key-value associations.
 * Note: for the Luka Virtual Machine project, a map can contain duplicate keys.
 *
 * <ul>
 * <li>Classname: LinkedDictionary.java
 * <li>14-04-2015
 * <li>Assignment 4
 * <li>Course: IT1 1121 A
 * <li>Langlois, Matt
 * <li>Student number: 7731813
 * <li>Faubert, Joel
 * <li>Student number: 2560106
 * </ul>
 *
 * @author Joel Faubert
 * @author Matt Langlois
 *
 */
public class LinkedDictionary implements Map<String, Token> {

    /*
     * Nested class for nodes of Dummy-Node doubly-linked list.
     */
    private static class Node {
        private Node next;
        private Node previous;
        private final String key;
        private Token value;

        private Node(final String key, final Token value, final Node next,
                final Node previous) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    private final Node head;

    /**
     * Constructor for LinkedDictionary
     */
    public LinkedDictionary() {
        head = new Node(null, null, null, null); // set up dummy node;
        head.next = head.previous = head;
    }

    /**
     * Returns true if the specified key is found in the dictionary
     *
     * @param K
     *            key to find in dictionary
     * @return true if key is found in the dictionary
     * @throws NullPointerException
     *             if specified key is null
     */
    @Override
    public boolean contains(final String key) {
        if (key == null)
            throw new NullPointerException("Key is null");

        Node p = head.previous;
        while (p != head) {
            if (p.key.equals(key)) {
                return true;
            }
            p = p.previous;
        }
        return false;
    }

    /**
     * Returns the leftmost (most recently added) value associated with this
     * specified key.
     *
     * @param K
     *            key to find in dictionary
     * @return value associated to specified key
     * @throws NoSuchElementException
     *             if specified key is not found in dictionary
     * @throws NullPointerException
     *             if specified key is null
     */
    @Override
    public Token get(final String key) {
        if (key == null)
            throw new NullPointerException("Key is null");

        Node p = head.previous;
        while (p != head) {
            if (p.key.equals(key))
                return p.value;
            p = p.previous;
        }
        throw new NoSuchElementException("Element " + key
                + " not found in dictionary");
    }

    /**
     * Adds a new definition to the dictionary
     *
     * @param K
     *            key to define in the dictionary
     * @param V
     *            value to associate to the key
     * @throws NullPointerException
     *             if specified key or value is null
     */
    @Override
    public void put(final String key, final Token value) {
        if (key == null)
            throw new NullPointerException("Key is null");
        if (value == null)
            throw new NullPointerException("Value is null");
        head.previous = new Node(key, value, head, head.previous);
        head.previous.previous.next = head.previous;
    }

    /**
     * Removes the most recently added occurrence of the specified key.
     *
     * @param K
     *            key to remove from the dictionary
     * @return returns value of key removed from dictionary
     * @throws NoSuchElementException
     *             if specified key is not found in dictionary
     * @throws NullPointerException
     *             if specified key or value is null
     */
    @Override
    public Token remove(final String key) {
        if (key == null)
            throw new NullPointerException("Key is null");

        Node p = head.previous;
        while (p != head) {
            if (p.key.equals(key)) {
                p.previous.next = p.next;
                p.next.previous = p.previous;
                return p.value;
            }
            p = p.previous;
        }
        throw new NoSuchElementException("Element " + key
                + " not found in dictionary");
    }

    /**
     * Replaces the value of the most recently added occurrence of the
     * association for the specified key.
     *
     * @param K
     *            key to redefine in the dictionary
     * @param V
     *            new value to associate to the existing key
     * @throws NoSuchElementException
     *             if specified key is not found in dictionary
     * @throws NullPointerException
     *             if specified key or value is null
     */
    @Override
    public void replace(final String key, final Token value) {
        if (key == null)
            throw new NullPointerException("Key is null");
        if (value == null)
            throw new NullPointerException("Value is null");

        Node p = head.previous;
        while (p != head) {
            if (p.key.equals(key)) {
                p.value = value;
                return;
            }
            p = p.previous;
        }
        throw new NoSuchElementException("Element " + key
                + " not found in dictionary");

    }

}
