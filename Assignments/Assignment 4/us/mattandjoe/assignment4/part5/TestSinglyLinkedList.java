package us.mattandjoe.assignment4.part5;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

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

    @Test
    public void testEmpty() {
        Assert.assertTrue((new SinglyLinkedList<String>()).indexOfAll("A")
                .isEmpty());
    }

    @Test
    public void testIndexOrder() {
        Assert.assertEquals(testListIndexes, testListLetters.indexOfAll("A"));
    }

    @Test()
    public void testString() {
        final String list = testListIndexes.toString();
        final String allIndex = testListLetters.indexOfAll("A").toString();
        Assert.assertEquals(list, allIndex);
    }

    @Test()
    public void testLength1000() {
        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();
        SinglyLinkedList<Integer> indexes = new SinglyLinkedList<Integer>();
        char[] chars = new char[] { 'A', 'B', 'C', 'D' };
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            char next = chars[random.nextInt(4)];
            list.addFirst(next);
            if (next == 'C') {
                indexes.addFirst(999 - i);
            }
        }
        Assert.assertEquals(indexes, list.indexOfAll('C'));
    }
    
    @Test()
    public void testLength1000String() {
        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();
        SinglyLinkedList<Integer> indexes = new SinglyLinkedList<Integer>();
        char[] chars = new char[] { 'A', 'B', 'C', 'D' };
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            char next = chars[random.nextInt(4)];
            list.addFirst(next);
            if (next == 'B') {
                indexes.addFirst(999 - i);
            }
        }
        Assert.assertEquals(indexes.toString(), list.indexOfAll('B').toString());
    }

    @Test(expected = NullPointerException.class)
    public void testNull() {
        testListLetters.indexOfAll(null);
    }

}
