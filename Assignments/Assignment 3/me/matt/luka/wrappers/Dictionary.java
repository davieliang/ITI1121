package me.matt.luka.wrappers;

import java.util.Arrays;
import java.util.NoSuchElementException;

import me.matt.luka.interfaces.Map;

/**
 * A Dictionary is a symbol map that keeps track of String-Token (identifier-value) associations.
 * Note: for the Luka Virtual Machine project, a Dictionary can contain duplicate keys.
 *
 * <ul>
 * <li>Classname: Dictionary.java
 * <li>22-03-2015
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

public class Dictionary implements Map<String, Token> {

    /**
     * Nested static object Pair used to associate a string key with a value Token
     */
    private static class Pair {
        private final String key; // word to define dictionary
        private Token value; // value to associate with word

        private Pair(final String key, final Token value) {
            this.key = key;
            this.value = value;
        }
    }

    public static final int INCREMENT = 5; // default increment size for dynamic array

    public static final int INITIAL_CAPACITY = 10; // default intial size for array
    private Pair[] pairs; // array to contain the definitions

    private int head; // initial index for new definitions

    /*
     * Constructor creates array of pairs of default size.
     * Initializes head to zero.
     */
    public Dictionary() {
        pairs = new Pair[Dictionary.INITIAL_CAPACITY]; // array to contain the definitions
        head = 0; // initial index for new definitions
    }

    /**
     * Returns true if the specified key is found in the dictionary
     *
     * @param key
     *            string to find in dictionary
     * @return true if key is found in the dictionary
     * @throws NullPointerException
     *             if specified key is null
     */
    @Override
    public boolean contains(final String key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }
        try {
            return this.getIndex(key) > -1;
        } catch (final NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Returns the most recently added value associated with this specified key.
     *
     * @param key
     *            string key to find in dictionary
     * @return Token value associated to specified key
     * @throws NoSuchElementException
     *             if specified key is not found in dictionary
     * @throws NullPointerException
     *             if specified key is null
     */
    @Override
    public Token get(final String key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }
        return pairs[this.getIndex(key)].value;
    }

    /*
     * Private method to find a specific key in current array and return it's index
     * 
     * Throws a NoSuchElementException if the key is not found
     */
    private int getIndex(final String key) {
        for (int i = head - 1; i >= 0; i--) {
            final Pair p = pairs[i];
            if (p.key.equals(key)) {
                return i;
            }
        }
        throw new NoSuchElementException("The map does not contain the key: "
                + key);
    }

    /**
     * Adds a new definition to the dictionary
     *
     * @param key
     *            string to define in the dictionary
     * @param value
     *            Token to associate to the key
     * @throws NullPointerException
     *             if specified key or value is null
     */
    @Override
    public void put(final String key, final Token value) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        } else if (value == null) {
            throw new NullPointerException("Value cannot be null");
        }
        if (head == pairs.length) {
            pairs = Arrays.copyOf(pairs, pairs.length + Dictionary.INCREMENT);
        }
        pairs[head++] = new Pair(key, value);
    }

    /**
     * Removes the leftmost (most recently added) occurrence of the specified key.
     *
     * @param key
     *            word to remove from the dictionary
     * @return value of key removed from dictionary
     * @throws NoSuchElementException
     *             if specified key is not found in dictionary
     * @throws NullPointerException
     *             if specified key or value is null
     */
    @Override
    public Token remove(final String key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }
        final int index = this.getIndex(key);
        final Token remove = pairs[index].value;
        pairs[index] = null;
        pairs = this.shiftArray(pairs, index);
        return remove;
    }

    /**
     * Replaces the value of the leftmost (most recently added) occurrence of the association for the specified key.
     *
     * @param key
     *            word to redefine in the dictionary
     * @param value
     *            new Token to associate to the existing key
     * @throws NoSuchElementException
     *             if specified key is not found in dictionary
     * @throws NullPointerException
     *             if specified key or value is null
     */
    @Override
    public void replace(final String key, final Token value) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        } else if (value == null) {
            throw new NullPointerException("Value cannot be null");
        }
        pairs[this.getIndex(key)].value = value;
    }

    /*
     * Private method for removing an element from the array
     */
    private Pair[] shiftArray(final Pair[] pairs, final int index) {
        final Pair[] result = new Pair[pairs.length];
        System.arraycopy(pairs, 0, result, 0, index);
        System.arraycopy(pairs, index + 1, result, index, pairs.length - index
                - 1);
        head--;
        return result;
    }

    /**
     * Generates string representation of contents of dictionary
     *
     * @return string representation of contents of dictionary
     */
    @Override
    public String toString() {
        String elems = "Dictionary: {elems = [";
        for (int i = head - 1; i >= 0; i--) {
            final Pair p = pairs[i];
            if (pairs[i] != null) {
                elems += "{key=" + p.key + ",value=" + p.value + "},";
            }
        }
        elems = (head > 0 ? elems.substring(0, elems.length() - 1) : elems)
                + "]}";
        return elems;
    }
}
