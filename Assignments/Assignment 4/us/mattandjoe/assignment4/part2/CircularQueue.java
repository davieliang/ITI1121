package us.mattandjoe.assignment4.part2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CircularQueue<E> implements Queue<E> {

    private int front, rear, size;
    private final E[] elems;

    @SuppressWarnings("unchecked")
    public CircularQueue(final int capacity) {
        elems = (E[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public E dequeue() {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        final E savedValue = elems[front];
        elems[front] = null; // ``scrubbing''
        size--;
        front = (front + 1) % elems.length;
        return savedValue;
    }

    public List<E> dequeue(final int amount) {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        if (size < amount) {
            throw new IndexOutOfBoundsException();
        }
        final List<E> elements = new LinkedList<E>();
        for (int i = 0; i < amount; i++) {
            final E savedValue = elems[front];
            elems[front] = null; // ``scrubbing''
            size--;
            front = (front + 1) % elems.length;
            elements.add(savedValue);
        }
        Collections.reverse(elements);
        return elements;
    }

    @Override
    public void enqueue(final E value) {
        rear = (rear + 1) % elems.length;
        elems[rear] = value;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public String toString() {

        final StringBuilder str = new StringBuilder(this.getClass().getName()
                + "[");

        if (size > 0) {

            int offset = 0;

            str.append(elems[front]);
            offset = offset + 1;

            while (offset < size) {

                str.append(", ");
                str.append(elems[(front + offset) % elems.length]);
                offset = offset + 1;

            }

        }

        str.append("]");

        return str.toString();

    }
}