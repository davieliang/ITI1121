package part3;

/* ITI 1121/1521. Introduction to Computer Science II
 *
 * Marcel Turcotte
 */

public class LinkedList<E> {

    // ----------------------------------------------------------
    // Implementing the doubly linked nodes (static nested class)
    // ----------------------------------------------------------

    private static class Node<E> {

        private E value;

        private Node<E> previous;
        private Node<E> next;

        private Node(E value, Node<E> previous, Node<E> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    // Instance variables

    private Node<E> head;
    private int size;

    /**
     * Creates a new linked list.
     */

    public LinkedList() {

        // Representation of the empty list using a dummy node
        head = new Node<E>(null, null, null);
        head.next = head.previous = head;
        size = 0;
    }

    // ----------------------------------------------------------
    // LinkedList methods
    // ----------------------------------------------------------

    /**
     * Returns the number of elements currently stored in this OrderedStructure.
     *
     * @return the number of elements of this strucutre.
     */

    public int size() {
        return size;
    }

    /**
     * Returns true if this collection contains no elements.
     *
     * @return true if this collection contains no elements
     */

    public boolean isEmpty() {
        return size == 0;
    }

    public LinkedList<E> remove(int from, int to) {
        if (to > size || from > to) {
            throw new IndexOutOfBoundsException();
        }
        LinkedList<E> result = new LinkedList<E>();
        int index = 0;
        Node<E> current = head.next;
        Node<E> start = null;
        while (index <= to) {
            if (index == from) {
                start = current.previous;
            }
            if (index >= from) {
                result.addLast(current.value);
            }
            current = current.next;
            index++;
        }
        start.next = current;
        current.previous = start;
        return result;
    }

    /**
     * Adds an element at the end of the list.
     *
     * @return true since duplicated values are allowed.
     * @throws IllegalArgumentException
     *             if obj is null.
     */

    public boolean addLast(E obj) {

        if (obj == null) {
            throw new IllegalArgumentException("null");
        }

        Node<E> before = head.previous;
        Node<E> after = head;

        before.next = new Node<E>(obj, before, after);
        after.previous = before.next;

        size++;

        return true;
    }

    /**
     * Adds an element at the start of the list.
     *
     * @return true since duplicated values are allowed.
     * @throws IllegalArgumentException
     *             if obj is null.
     */

    public boolean addFirst(E obj) {

        if (obj == null) {
            throw new IllegalArgumentException("null");
        }

        Node<E> before = head;
        Node<E> after = head.next;

        before.next = new Node<E>(obj, before, after);
        after.previous = before.next;

        size++;

        return true;
    }

    /**
     * Returns the element at the specified position; the first
     * element has the index 0.
     *
     * @return the element at the specified position.
     * @throws IndexOutOfBoundsException
     *             if pos is out of range (pos < 0 || pos >= size()).
     */

    public E get(int pos) {

        if (pos < 0 || pos > (size - 1)) {
            throw new IndexOutOfBoundsException(Integer.toString(pos));
        }

        Node<E> p = head.next;

        for (int i = 0; i < pos; i++) {
            p = p.next;
        }

        return p.value;
    }

    // ----------------------------------------------------------
    // Other instance methods
    // ----------------------------------------------------------

    public String toString() {
        StringBuffer answer = new StringBuffer("[");
        Node<E> p = head.next;
        while (p != head) {
            if (p != head.next) {
                answer.append(",");
            }
            answer.append(p.value);
            p = p.next;
        }
        answer.append("]");
        return answer.toString();
    }

}