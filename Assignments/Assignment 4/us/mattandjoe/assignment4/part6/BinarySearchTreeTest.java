package us.mattandjoe.assignment4.part6;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {

    @Test()
    public void testRootSingle() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(4);

        Assert.assertEquals(1, t.count(4, 4));
    }

    @Test()
    public void testRootNot() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(4);

        Assert.assertEquals(0, t.count(2, 3));
    }

    @Test()
    public void testRootCenter() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(4);

        Assert.assertEquals(1, t.count(3, 5));
    }

    @Test()
    public void testRootLower() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(3);

        Assert.assertEquals(1, t.count(3, 5));
    }

    @Test()
    public void testRootUpper() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(4);

        Assert.assertEquals(1, t.count(3, 5));
    }

    @Test()
    public void testLeftCenter() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(5);
        t.add(3);

        Assert.assertEquals(1, t.count(2, 4));
    }

    @Test()
    public void testLeftLower() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(5);
        t.add(2);

        Assert.assertEquals(1, t.count(2, 4));
    }

    @Test()
    public void testLeftUpper() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(5);
        t.add(4);

        Assert.assertEquals(1, t.count(2, 4));
    }

    @Test()
    public void testLeftSingle() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(5);
        t.add(4);

        Assert.assertEquals(1, t.count(4, 4));
    }

    @Test()
    public void testLeftNot() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(5);
        t.add(4);

        Assert.assertEquals(0, t.count(2, 3));
    }

    @Test()
    public void testRightCenter() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(5);
        t.add(7);

        Assert.assertEquals(1, t.count(6, 8));
    }

    @Test()
    public void testRightLower() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(5);
        t.add(6);

        Assert.assertEquals(1, t.count(6, 8));
    }

    @Test()
    public void testRightUpper() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(5);
        t.add(8);

        Assert.assertEquals(1, t.count(6, 8));
    }

    @Test()
    public void testRightSingle() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(5);
        t.add(8);

        Assert.assertEquals(1, t.count(8, 8));
    }

    @Test()
    public void testRightNot() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(5);
        t.add(8);

        Assert.assertEquals(0, t.count(10, 11));
    }

    @Test()
    public void testDuplicate() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(4);
        t.add(4);

        Assert.assertEquals(1, t.count(3, 5));
    }

    @Test()
    public void testLeftDuplicate() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(5);
        t.add(4);
        t.add(4);

        Assert.assertEquals(1, t.count(4, 4));
    }

    @Test()
    public void testRightDuplicate() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(5);
        t.add(6);
        t.add(6);

        Assert.assertEquals(1, t.count(6, 6));
    }

    @Test()
    public void testFullTree() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(5);
        t.add(3);
        t.add(8);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(6);
        t.add(7);
        t.add(9);
        t.add(6);
        t.add(1);

        Assert.assertEquals(9, t.count(0, 10));
    }

    @Test()
    public void testRightFullTree() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(5);
        t.add(3);
        t.add(8);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(6);
        t.add(7);
        t.add(9);
        t.add(6);
        t.add(1);

        Assert.assertEquals(5, t.count(5, 10));
    }

    @Test()
    public void testLeftFullTree() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        t.add(5);
        t.add(3);
        t.add(8);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(6);
        t.add(7);
        t.add(9);
        t.add(6);
        t.add(1);

        Assert.assertEquals(5, t.count(0, 5));
    }

    @Test(expected = NullPointerException.class)
    public void checkRootNull() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();
        t.add(null);
    }

    @Test(expected = NullPointerException.class)
    public void testNull() {
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();

        Assert.assertEquals(2, t.count(4, 5));
    }

}