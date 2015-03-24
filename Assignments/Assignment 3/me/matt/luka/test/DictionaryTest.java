package me.matt.luka.test;

import java.util.NoSuchElementException;

import me.matt.luka.wrappers.Dictionary;
import me.matt.luka.wrappers.Token;

import org.junit.Assert;
import org.junit.Test;

/**
 * Some tests for Dictionary...
 *
 * @author Marcel Turcotte (turcotte@eecs.uottawa.ca)
 *         <ul>
 *         <li>Classname: DictionaryTest.java
 *         <li>23-03-2015
 *         <li>Assignment 3
 *         <li>Course: IT1 1121 A
 *         <li>Langlois, Matt
 *         <li>Student number: 7731813
 *         <li>Faubert, Joel
 *         <li>Student number: 2560106
 *         </ul>
 */
public class DictionaryTest {

    @Test()
    public void testContainsEmpty() {
        System.out.println("test: testContainsEmpty");
        final Dictionary dict = new Dictionary();
        Assert.assertFalse(dict.contains("X"));
    }

    @Test()
    public void testContainsNotFound() {
        System.out.println("test: testContainsNoFound");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertFalse(dict.contains("W"));
    }

    @Test(expected = NullPointerException.class)
    public void testContainsNullPointerException() {
        System.out.println("test: testContainsNullPointerException");
        final Dictionary dict = new Dictionary();
        dict.contains(null);
    }

    @Test()
    public void testContainsX() {
        System.out.println("test: testContainsX");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertTrue(dict.contains("X"));
    }

    @Test()
    public void testContainsXX() {
        System.out.println("test: testContainsXX");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("X", new Token(4));
        Assert.assertTrue(dict.contains("X"));
    }

    @Test()
    public void testContainsY() {
        System.out.println("test: testContainsY");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertTrue(dict.contains("Y"));
    }

    @Test()
    public void testContainsYY() {
        System.out.println("test: testContainsYY");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Y", new Token(4));
        Assert.assertTrue(dict.contains("Y"));
    }

    @Test()
    public void testContainsZ() {
        System.out.println("test: testContainsZ");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertTrue(dict.contains("Z"));
    }

    @Test()
    public void testContainsZZ() {
        System.out.println("test: testContainsZZ");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Z", new Token(4));
        Assert.assertTrue(dict.contains("Z"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetNoSuchElementException() {
        System.out.println("test: testGetNoSuchElementException");
        final Dictionary dict = new Dictionary();
        dict.get("V");
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetNoSuchElementExceptionNonEmpty() {
        System.out.println("test: testGetNoSuchElementExceptionNonEmpty");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.get("V");
    }

    @Test(expected = NullPointerException.class)
    public void testGetNullPointerException() {
        System.out.println("test: testGetNullPointerException");
        final Dictionary dict = new Dictionary();
        dict.get(null);
    }

    @Test()
    public void testGetStatic() {
        System.out.println("test: testStatic");
        final Dictionary d1 = new Dictionary();
        final Dictionary d2 = new Dictionary();
        d1.put("X", new Token(1));
        Assert.assertFalse(d2.contains("X"));
    }

    @Test()
    public void testGetX() {
        System.out.println("test: testGetX");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertEquals(new Token(1), dict.get("X"));
    }

    @Test()
    public void testGetXX() {
        System.out.println("test: testGetXX");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("X", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("X"));
    }

    @Test()
    public void testGetY() {
        System.out.println("test: testGetY");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertEquals(new Token(2), dict.get("Y"));
    }

    @Test()
    public void testGetYY() {
        System.out.println("test: testGetYY");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Y", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("Y"));
    }

    @Test()
    public void testGetZ() {
        System.out.println("test: testGetZ");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertEquals(new Token(3), dict.get("Z"));
    }

    @Test()
    public void testGetZZ() {
        System.out.println("test: testGetZZ");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Z", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("Z"));
    }

    @Test()
    public void testPutDyncamicArray() {
        System.out.println("test: testPutDyncamicArray");
        final Dictionary dict = new Dictionary();
        for (int i = 0; i < 1000; i++) {
            dict.put("X" + i, new Token(i));
        }
        for (int i = 0; i < 1000; i++) {
            Assert.assertEquals(new Token(i), dict.get("X" + i));
        }
    }

    @Test(expected = NullPointerException.class)
    public void testPutNullPointerExceptionKey() {
        System.out.println("test: testPutNullPointerExceptionKey");
        final Dictionary dict = new Dictionary();
        dict.put(null, new Token(1));

    }

    @Test(expected = NullPointerException.class)
    public void testPutNullPointerExceptionKeyValue() {
        System.out.println("test: testPutNullPointerExceptionKeyValue");
        final Dictionary dict = new Dictionary();
        dict.put(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void testPutNullPointerExceptionValue() {
        System.out.println("test: testPutNullPointerExceptionValue");
        final Dictionary dict = new Dictionary();
        dict.put("X", null);

    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveNoSuchElementException() {
        System.out.println("test: testRemoveNoSuchElementException");
        final Dictionary dict = new Dictionary();
        dict.remove("V");
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveNoSuchElementExceptionNonEmpty() {
        System.out.println("test: testRemoveNoSuchElementExceptionNonEmpty");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.remove("V");
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNullPointerException() {
        System.out.println("test: testRemoveNullPointerException");
        final Dictionary dict = new Dictionary();
        dict.remove(null);
    }

    @Test()
    public void testRemoveX() {
        System.out.println("test: testRemoveX");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.remove("X");
        Assert.assertFalse(dict.contains("X"));
        Assert.assertEquals(new Token(2), dict.get("Y"));
        Assert.assertEquals(new Token(3), dict.get("Z"));
    }

    @Test()
    public void testRemoveXX() {
        System.out.println("test: testRemoveXX");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("X", new Token(4));
        dict.remove("X");
        Assert.assertEquals(new Token(1), dict.get("X"));
        Assert.assertEquals(new Token(2), dict.get("Y"));
        Assert.assertEquals(new Token(3), dict.get("Z"));
    }

    @Test()
    public void testRemoveY() {
        System.out.println("test: testRemoveY");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.remove("Y");
        Assert.assertFalse(dict.contains("Y"));
        Assert.assertEquals(new Token(1), dict.get("X"));
        Assert.assertEquals(new Token(3), dict.get("Z"));
    }

    @Test()
    public void testRemoveYY() {
        System.out.println("test: testRemoveYY");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Y", new Token(4));
        dict.remove("Y");
        Assert.assertEquals(new Token(1), dict.get("X"));
        Assert.assertEquals(new Token(2), dict.get("Y"));
        Assert.assertEquals(new Token(3), dict.get("Z"));
    }

    @Test()
    public void testRemoveZ() {
        System.out.println("test: testRemoveZ");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.remove("Z");
        Assert.assertFalse(dict.contains("Z"));
        Assert.assertEquals(new Token(1), dict.get("X"));
        Assert.assertEquals(new Token(2), dict.get("Y"));
    }

    @Test()
    public void testRemoveZZ() {
        System.out.println("test: testRemoveZZ");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Z", new Token(4));
        dict.remove("Z");
        Assert.assertEquals(new Token(1), dict.get("X"));
        Assert.assertEquals(new Token(2), dict.get("Y"));
        Assert.assertEquals(new Token(3), dict.get("Z"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testReplaceNoSuchElementException() {
        System.out.println("test: testReplaceNoSuchElementException");
        final Dictionary dict = new Dictionary();
        dict.replace("V", new Token(1));
    }

    @Test(expected = NullPointerException.class)
    public void testReplaceNullPointerExceptionKey() {
        System.out.println("test: testReplaceNullPointerExceptionKey");
        final Dictionary dict = new Dictionary();
        dict.replace(null, new Token(1));

    }

    @Test(expected = NullPointerException.class)
    public void testReplaceNullPointerExceptionKeyValue() {
        System.out.println("test: testReplaceNullPointerExceptionKeyValue");
        final Dictionary dict = new Dictionary();
        dict.replace(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void testReplaceNullPointerExceptionValue() {
        System.out.println("test: testReplaceNullPointerExceptionValue");
        final Dictionary dict = new Dictionary();
        dict.replace("X", null);

    }

    @Test()
    public void testReplaceX() {
        System.out.println("test: testReplaceX");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.replace("X", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("X"));
    }

    @Test()
    public void testReplaceXX() {
        System.out.println("test: testReplaceXX");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("X", new Token(4));
        dict.replace("X", new Token(5));
        Assert.assertEquals(new Token(5), dict.get("X"));
    }

    @Test()
    public void testReplaceY() {
        System.out.println("test: testReplaceY");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.replace("Y", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("Y"));
    }

    @Test()
    public void testReplaceYY() {
        System.out.println("test: testReplaceYY");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Y", new Token(4));
        dict.replace("Y", new Token(5));
        Assert.assertEquals(new Token(5), dict.get("Y"));
    }

    @Test()
    public void testReplaceZ() {
        System.out.println("test: testReplaceZ");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.replace("Z", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("Z"));
    }

    @Test()
    public void testReplaceZZ() {
        System.out.println("test: testReplaceZZ");
        final Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Z", new Token(4));
        dict.replace("Z", new Token(5));
        Assert.assertEquals(new Token(5), dict.get("Z"));
    }

}