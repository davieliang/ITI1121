package us.mattandjoe.assignment4.part5;

/* ITI 1121/1521. Introduction to Computer Science II
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
        first = new Node<E>(item, first);
    }

    public SinglyLinkedList<Integer> indexOfAll(final E element) {
        final SinglyLinkedList<Integer> ints = new SinglyLinkedList<Integer>();
        this.indexOfAll(ints, element, first, 0);
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
        if (current.value.equals(value)) {
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