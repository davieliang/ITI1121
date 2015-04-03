public class OrderedList<T extends Comparable<T>> implements
        OrderedStructure<T> {

    private static class Node<E> {

        private Node<E> next;
        private Node<E> previous;
        private E value;

        private Node(E value, Node<E> next, Node<E> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    private Node<T> head;
    private int size = 0;

    public OrderedList() {
        head = new Node<T>(null, null, null);
        head.next = head.previous = head;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean add(Comparable<T> obj) throws IllegalArgumentException {
        if (obj == null) {
            throw new NullPointerException();
        }
        Node<T> node = head.next;
        while (node != head) {
            if (node.value.compareTo((T) obj) > 0) {
                node.previous.next = new Node<T>((T) obj, node, node.previous);
                node.previous = node.previous.next;
                size++;
                return true;
            }
            node = node.next;
        }
        head.previous = head.previous.next = new Node<T>((T) obj, head, head.previous);
        size++;
        return true;
    }

    @Override
    public T get(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException(String.valueOf(pos));
        }
        return null;
    }

    @Override
    public void remove(int pos) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub

    }

    public String toString() {
        String nodes = "";
        if (size > 0) {
            Node<T> p = head.next;
            while (p != head) {
                nodes += p.value.toString() + ", ";
            }
            nodes = nodes.substring(0, nodes.length() - 2);
        }
        return "[" + nodes + "]";
    }
}
