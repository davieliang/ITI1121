package us.mattandjoe.assignment4.part5;

/*
 * ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 * 
 * Marcel Turcotte
 */

public class SinglyLinkedList<E> {

    private static class Node<E> {
        private final E value;
        private final Node<E> next;

        private Node(final E value, final Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    // Instance variable
    private Node<E> first;

    // ----------------------------------------------------------
    // SinglyLinkedList methods
    // ----------------------------------------------------------

    public void addFirst(final E item) {
        if (item == null) {
            throw new NullPointerException("Illegal argument");
        }

        first = new Node<E>(item, first);
    }

    public SinglyLinkedList<Integer> indexOfAll(final E element) {
        if (element == null) {
            throw new NullPointerException("Illegal Argument");
        }
        final SinglyLinkedList<Integer> ints = new SinglyLinkedList<Integer>();
        if (first != null) {
            this.indexOfAll(ints, element, first, 0);
        }
        return ints;
    }

    private void indexOfAll(final SinglyLinkedList<Integer> ints,
            final E value, final Node<E> current, int index) {

        /*
         * Recursive case: Call the method on the next linked element
         */
        if (current.next != null) {
            this.indexOfAll(ints, value, current.next, ++index);
            index--;
        }

        /*
         * Base case: Add the element to the list
         */
        if ((current.value == null && value == null)
                || current.value.equals(value)) {
            ints.addFirst(index);
        }

    }

    public boolean isEmpty() {
        return first == null;
    }

    // ----------------------------------------------------------
    // Other instance methods
    // ----------------------------------------------------------

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SinglyLinkedList<?>)) {
            return false;
        }
        return obj == this ? true : equal(this, (SinglyLinkedList<?>) obj);
    }

    private boolean equal(SinglyLinkedList<E> l1, SinglyLinkedList<?> l2) {
        return (l1.isEmpty() && l2.isEmpty()) ? true : equal(l1, l2, l1.first,
                l2.first);
    }

    private boolean equal(SinglyLinkedList<E> l1, SinglyLinkedList<?> l2,
            Node<E> n1, Node<?> n2) {
        if (n1 == null || n2 == null) {
            return (n1 == null && n2 == null) ? true : false;
        } else {
            return n1.value.equals(n2.value) ? equal(l1, l2, n1.next, n2.next)
                    : false;
        }
    }

    @Override
    public String toString() {
        return "{" + this.toString(first) + "}";
    }

    private String toString(final Node<E> p) {

        String result = "";

        if (p != null) {
            result = p.value.toString();
            if (p.next != null) {
                result = result + "," + this.toString(p.next);
            }
        }

        return result;
    }
}