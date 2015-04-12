package us.mattandjoe.assignment4.part5;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * A unit test for the SinglyLinkedList implementation
 *
 * <ul>
 * <li>22-03-2015
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
public class TestSinglyLinkedList {

    final SinglyLinkedList<String> testListLetters;
    final SinglyLinkedList<Integer> testListIndexes;

    public TestSinglyLinkedList() {

        testListLetters = new SinglyLinkedList<String>();
        testListIndexes = new SinglyLinkedList<Integer>();

        testListLetters.addFirst("A");
        testListLetters.addFirst("D");
        testListLetters.addFirst("C");
        testListLetters.addFirst("A");
        testListLetters.addFirst("A");
        testListLetters.addFirst("B");
        testListLetters.addFirst("A");

        testListIndexes.addFirst(6);
        testListIndexes.addFirst(3);
        testListIndexes.addFirst(2);
        testListIndexes.addFirst(0);
    }

    @Test(expected = NullPointerException.class)
    public void testAddNull() {
        final SinglyLinkedList<String> test = new SinglyLinkedList<String>();
        test.addFirst("A");
        test.addFirst("B");
        test.addFirst("C");
        test.indexOfAll(null);
    }

    @Test
    public void testEmpty() {
        Assert.assertTrue((new SinglyLinkedList<String>()).indexOfAll("A")
                .isEmpty());
    }

    @Test()
    public void testEqualsEmpty() {
        final SinglyLinkedList<String> test = new SinglyLinkedList<String>();
        final SinglyLinkedList<Character> other = new SinglyLinkedList<Character>();

        Assert.assertTrue(test.equals(other));
    }

    @Test()
    public void testEqualsLenght() {
        final SinglyLinkedList<String> test = new SinglyLinkedList<String>();
        test.addFirst("A");
        test.addFirst("A");
        test.addFirst("B");
        test.addFirst("C");

        final SinglyLinkedList<String> other = new SinglyLinkedList<String>();
        other.addFirst("A");
        other.addFirst("B");
        other.addFirst("C");

        Assert.assertFalse(test.equals(other));
    }

    @Test()
    public void testEqualsNull() {
        final SinglyLinkedList<String> test = new SinglyLinkedList<String>();
        test.addFirst("A");
        test.addFirst("B");
        test.addFirst("C");
        Assert.assertFalse(test.equals(null));
    }

    @Test()
    public void testEqualsOther() {
        final SinglyLinkedList<String> test = new SinglyLinkedList<String>();
        test.addFirst("A");
        test.addFirst("B");
        test.addFirst("C");

        final SinglyLinkedList<String> other = new SinglyLinkedList<String>();
        other.addFirst("A");
        other.addFirst("B");
        other.addFirst("C");

        Assert.assertTrue(test.equals(other));
    }

    @Test()
    public void testEqualsThis() {
        final SinglyLinkedList<String> test = new SinglyLinkedList<String>();
        test.addFirst("A");
        test.addFirst("B");
        test.addFirst("C");
        Assert.assertTrue(test.equals(test));
    }

    @Test()
    public void testEqualsTypeChange() {
        final SinglyLinkedList<String> test = new SinglyLinkedList<String>();
        test.addFirst("A");
        test.addFirst("B");
        test.addFirst("C");

        final SinglyLinkedList<Character> other = new SinglyLinkedList<Character>();
        other.addFirst('A');
        other.addFirst('B');
        other.addFirst('C');

        Assert.assertFalse(test.equals(other));
    }

    @Test()
    public void testEqualsTypeObject() {
        final SinglyLinkedList<String> test = new SinglyLinkedList<String>();
        test.addFirst("A");
        test.addFirst("B");
        test.addFirst("C");

        final SinglyLinkedList<Object> other = new SinglyLinkedList<Object>();
        other.addFirst("A");
        other.addFirst("B");
        other.addFirst("C");

        Assert.assertTrue(test.equals(other));
    }

    @Test
    public void testIndexOrder() {
        Assert.assertEquals(testListIndexes, testListLetters.indexOfAll("A"));
    }

    @Test()
    public void testLength1000() {
        final SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();
        final SinglyLinkedList<Integer> indexes = new SinglyLinkedList<Integer>();
        final char[] chars = new char[] { 'A', 'B', 'C', 'D' };
        final Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            final char next = chars[random.nextInt(4)];
            list.addFirst(next);
            if (next == 'C') {
                indexes.addFirst(999 - i);
            }
        }
        Assert.assertEquals(indexes, list.indexOfAll('C'));
    }

    @Test()
    public void testLength1000String() {
        final SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();
        final SinglyLinkedList<Integer> indexes = new SinglyLinkedList<Integer>();
        final char[] chars = new char[] { 'A', 'B', 'C', 'D' };
        final Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            final char next = chars[random.nextInt(4)];
            list.addFirst(next);
            if (next == 'B') {
                indexes.addFirst(999 - i);
            }
        }
        Assert.assertEquals(indexes.toString(), list.indexOfAll('B').toString());
    }

    @Test(expected = StackOverflowError.class)
    public void testMassiveEquals() {
        final SinglyLinkedList<Integer> test = new SinglyLinkedList<Integer>();
        final SinglyLinkedList<Integer> test2 = new SinglyLinkedList<Integer>();
        for (int i = 0; i < 1000000; i++) {
            test.addFirst(i);
            test2.addFirst(i);
        }
        Assert.assertFalse(test.equals(test2));
    }

    @Test(expected = StackOverflowError.class)
    public void testMassiveIndexOfAll() {
        final SinglyLinkedList<Integer> test = new SinglyLinkedList<Integer>();
        for (int i = 0; i < 1000000; i++) {
            test.addFirst(1);
        }
        test.indexOfAll(1);
    }

    @Test(expected = NullPointerException.class)
    public void testNull() {
        testListLetters.indexOfAll(null);
    }

    @Test()
    public void testString() {
        final String list = testListIndexes.toString();
        final String allIndex = testListLetters.indexOfAll("A").toString();
        Assert.assertEquals(list, allIndex);
    }

}
