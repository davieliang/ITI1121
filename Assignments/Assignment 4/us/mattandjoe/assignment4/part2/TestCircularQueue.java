package us.mattandjoe.assignment4.part2;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import us.mattandjoe.assignment4.util.StudentInfo;

/**
 * JUnit test cases for CircularQueue class
 * <ul>
 * <li>Classname: TestCircularQueue.java
 * <li>14-04-2015
 * <li>Assignment 4
 * <li>Course: IT1 1121 A
 * <li>Langlois, Matt
 * <li>Student number: 7731813
 * <li>Faubert, Joel
 * <li>Student number: 2560106
 * </ul>
 */
public class TestCircularQueue {

    @BeforeClass
    public static void displayInfo() {
        StudentInfo.display("CircularQueue");
    }

    @Test(expected = EmptyQueueException.class)
    public void testEmpty() {
        final CircularQueue<Integer> q = new CircularQueue<Integer>(8);
        q.dequeue(10);
    }

    @Test()
    public void testEntire() {
        final CircularQueue<Integer> q = new CircularQueue<Integer>(8);
        final LinkedList<Integer> expected = new LinkedList<Integer>();
        for (int i = 0; i < 8; i++) {
            q.enqueue(i);
            expected.addFirst(i);
        }
        Assert.assertEquals(expected, q.dequeue(8));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testNegative() {
        final CircularQueue<Integer> q = new CircularQueue<Integer>(8);
        for (int i = 0; i < 8; i++) {
            q.enqueue(i);
        }
        q.dequeue(-1);
    }

    @Test()
    public void testPartial() {
        final CircularQueue<Integer> q = new CircularQueue<Integer>(8);
        for (int i = 0; i < 8; i++) {
            q.enqueue(i);
        }
        final LinkedList<Integer> expected = new LinkedList<Integer>();
        expected.add(2);
        expected.add(1);
        expected.add(0);
        Assert.assertEquals(expected, q.dequeue(3));
    }

    @Test()
    public void testSingleElement() {
        final CircularQueue<Integer> q = new CircularQueue<Integer>(8);
        for (int i = 0; i < 8; i++) {
            q.enqueue(i);
        }
        final LinkedList<Integer> expected = new LinkedList<Integer>();
        expected.add(0);
        Assert.assertEquals(expected, q.dequeue(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testTooLarge() {
        final CircularQueue<Integer> q = new CircularQueue<Integer>(8);
        for (int i = 0; i < 8; i++) {
            q.enqueue(i);
        }
        q.dequeue(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testTooSmall() {
        final CircularQueue<Integer> q = new CircularQueue<Integer>(8);
        for (int i = 0; i < 8; i++) {
            q.enqueue(i);
        }
        q.dequeue(0);
    }

}