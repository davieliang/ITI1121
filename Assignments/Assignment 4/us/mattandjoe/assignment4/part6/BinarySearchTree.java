package us.mattandjoe.assignment4.part6;

/**
 * An implementation of a BinarySearchTree
 *
 * <ul>
 * <li>14-04-2015
 * <li>Assignment 4
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

    /**
     * Searches the binary tree for occurrences of values within a specified interval
     *
     * @param low
     *            The minimum range of the interval
     * @param high
     *            The maximum range of the interval
     * @return total number of occurrences found in the search tree matching given interval
     */
    public int count(final E low, final E high) {
        if (low == null || high == null) {
            throw new NullPointerException("Illegal Argument!");
        }
        if (root == null) {
            throw new NullPointerException("Root node is null");
        }
        /*
         * Verify the list is initialized with at least one object in it, otherwise throw a null pointer exception;
         * can't count an empty list!
         */
        if (low.compareTo(high) < 0) {
            /*
             * If the root is in the list begin counting at 1, otherwise start counting at 0
             */
            return this.visitNode(low, high, root);
        } else {
            return this.visitNode(high, low, root); // assume user incorrectly passed range parameters and inverse
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

    private int traverse(final E low, final E high, final Node<E> node,
            int count) {
        /*
         * Validate there is another left node
         * 
         * Validate the current node's value is within the bounds of our comparison
         * otherwise visiting the left would be a waste of CPU usage
         * 
         * Do the same for the right node, except using the high value instead of the low value
         * 
         * If our checks pass recursively call the count function to determine the amount to increment
         * 
         * Going left we don't compare to the high value because to the left may be a value we need
         * 
         * For example
         * 4
         * right ->
         * 10
         * left <-
         * 9
         * left <-
         * 8
         * left <-
         * 7
         * Then count from low of 4 to a high of 7
         */
        if (node.left != null) {
            if (node.value.compareTo(low) > 0) {
                count += this.visitNode(low, high, node.left);
            }
        }
        if (node.right != null) {
            if (node.value.compareTo(high) < 0) {
                count += this.visitNode(low, high, node.right);
            }
        }
        return count;
    }

    private int visitNode(final E low, final E high, final Node<E> node) {

        /*
         * Validate the value of the current node then recursively visit the next node
         */
        if (node.value.compareTo(low) >= 0 && node.value.compareTo(high) <= 0) {
            return this.traverse(low, high, node, 1);// Visit the next node with an incremented count
        } else {
            return this.traverse(low, high, node, 0);// Visit the next node, incrementing the count by 0. This process is required for an unbalanced
                                                     // tree
        }
    }

}