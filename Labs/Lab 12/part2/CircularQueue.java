package part2;

import java.util.NoSuchElementException;

public class CircularQueue<E> implements Queue<E> {

    private int front, rear, size;
    private E[] elems;

    @SuppressWarnings("unchecked")
    public CircularQueue(int capacity) {
        elems = (E[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void enqueue(E value) {
        rear = (rear + 1) % elems.length;
        elems[rear] = value;
        size = Math.min(size + 1, elems.length);
    }

    public E dequeue() {
        E savedValue = elems[front];
        elems[front] = null;
        size--;
        front = (front + 1) % elems.length;
        return savedValue;
    }

    private class CircularQueueIterator implements QueueIterator<E> {
        private int current;

        private CircularQueueIterator() {
            current = front;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elems[current++];
        }

        public boolean hasNext() {
            return size != 0 && current != rear;
        }
    }

    public CircularQueueIterator iterator() {
        return new CircularQueueIterator();
    }

}