package me.matt.luka.wrappers;

import me.matt.luka.exception.EmptyStackException;
import me.matt.luka.interfaces.Stack;

/**
 * Linked implementation of the interface Stack.
 *
 * @author Marcel Turcotte
 * @see Stack
 */
public class LinkedStack<E> implements Stack<E> {

    /**
     * Instances of the nested class Elem are used to store the elements of this
     * LinkedStack.
     */
    private static class Elem<E> {

        private final E info;
        private final Elem<E> next;

        private Elem(final E info, final Elem<E> next) {
            this.info = info;
            this.next = next;
        }
    }

    /**
     * The instance variable <code>top</code> designates the top element of the
     * stack.
     */
    private Elem<E> top;

    private int size;

    /**
     * Constructs an empty stack.
     */
    public LinkedStack() {
        top = null;
        size = 0;
    }

    /**
     * Tests if this stack is empty.
     *
     * @return true if this stack contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Returns the top element of this stack without removing it.
     *
     * @return the top element of the stack.
     * @throws EmptyStackException
     *             if the stack was empty when the method was
     *             called.
     */
    @Override
    public E peek() {
        return this.peek(0);
    }

    @Override
    public E peek(final int distance) {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        if (distance >= size) {
            throw new IndexOutOfBoundsException(
                    "Cannot peek beyond the size of the stack");
        }
        Elem<E> current = top;
        for (int i = 0; i < distance; i++) {
            current = current.next;
        }
        return current.info;
    }

    /**
     * Returns and remove the top element of this stack.
     *
     * @return the top element of the stack.
     * @throws EmptyStackException
     *             if the stack was empty when the method was
     *             called.
     */
    @Override
    public E pop() {
        // pre-conditions:
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        final E savedInfo = top.info;

        top = top.next;
        size--;
        return savedInfo;
    }

    /**
     * Puts the element onto the top of this stack.
     *
     * @param elem
     *            the element that will be pushed onto the top of the stack.
     */
    @Override
    public void push(final E elem) {

        if (elem == null) {
            throw new NullPointerException();
        }
        size++;
        top = new Elem<E>(elem, top);
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of this object.
     *
     * @return a string representation of this object.
     */
    @Override
    public String toString() {

        StringBuffer b;
        b = new StringBuffer("LinkedStack: {");

        Elem<E> p;
        p = top;
        while (p != null) {
            if (p != top) {
                b.append(",");
            }
            b.append(p.info);
            p = p.next;
        }

        b.append("}");
        return b.toString();
    }

}
