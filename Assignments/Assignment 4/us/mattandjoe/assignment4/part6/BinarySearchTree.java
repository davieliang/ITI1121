package us.mattandjoe.assignment4.part6;

public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<F> {

        private final F value;
        private Node<F> left;
        private Node<F> right;

        private Node(final F value) {
            this.value = value;
            left = null;
            right = null;
        }

    }

    private Node<E> root = null;

    /**
     * Inserts an object into this BinarySearchTree.
     *
     * @param obj
     *            item to be added
     * @return true if the object has been added and false otherwise
     */

    public boolean add(final E obj) {

        // pre-condtion:
        if (obj == null) {
            throw new NullPointerException("Illegal Argument");
        }

        // special case:
        if (root == null) {
            root = new Node<E>(obj);
            return true;
        }

        // general case:
        return this.add(obj, root);
    }

    private boolean add(final E obj, final Node<E> current) {

        boolean result;
        final int test = obj.compareTo(current.value);

        if (test == 0) {
            result = false; // already exists, not added
        } else if (test < 0) {
            if (current.left == null) {
                current.left = new Node<E>(obj);
                result = true;
            } else {
                result = this.add(obj, current.left);
            }
        } else {
            if (current.right == null) {
                current.right = new Node<E>(obj);
                result = true;
            } else {
                result = this.add(obj, current.right);
            }
        }
        return result;
    }

    public int count(final E low, final E high) {
        if (root != null) {
            if (root.value.compareTo(low) >= 0
                    && root.value.compareTo(high) <= 0) {
                return this.count(low, high, root, 1);
            } else {
                return this.count(low, high, root, 0);
            }
        }
        return -1;
    }

    public int count(final E low, final E high, final Node<E> next, int count) {
        if (next.left != null) {
            count += this.count(next.left, low, high);
        }
        if (next.right != null) {
            count += this.count(next.right, low, high);
        }
        return count;
    }

    private int count(final Node<E> node, final E low, final E high) {
        if (node.value.compareTo(low) >= 0 && node.value.compareTo(high) <= 0) {
            return this.count(low, high, node, 1);// Visit the right node with an incremented count
        } else {
            return this.count(low, high, node, 0);// Visit the right node
        }
    }

    @Override
    public String toString() {
        return this.toString(root);
    }

    private String toString(final Node<E> p) {
        if (p == null) {
            return "null";
        } else {
            return "(" + this.toString(p.left) + "," + p.value + ","
                    + this.toString(p.right) + ")";
        }
    }

}