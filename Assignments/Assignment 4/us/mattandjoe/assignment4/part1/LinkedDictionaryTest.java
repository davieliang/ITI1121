package us.mattandjoe.assignment4.part1;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

/**
 * Some tests for LinkedDictionary...
 *
 * @author Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */
public class LinkedDictionaryTest {

    @Test()
    public void testContainsEmpty() {
        System.out.println("test: testContainsEmpty");
        final LinkedDictionary dict = new LinkedDictionary();
        Assert.assertFalse(dict.contains("X"));
    }

    @Test()
    public void testContainsNotFound() {
        System.out.println("test: testContainsNoFound");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertFalse(dict.contains("W"));
    }

    @Test(expected = NullPointerException.class)
    public void testContainsNullPointerException() {
        System.out.println("test: testContainsNullPointerException");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.contains(null);
    }

    @Test()
    public void testContainsX() {
        System.out.println("test: testContainsX");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertTrue(dict.contains("X"));
    }

    @Test()
    public void testContainsXX() {
        System.out.println("test: testContainsXX");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("X", new Token(4));
        Assert.assertTrue(dict.contains("X"));
    }

    @Test()
    public void testContainsY() {
        System.out.println("test: testContainsY");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertTrue(dict.contains("Y"));
    }

    @Test()
    public void testContainsYY() {
        System.out.println("test: testContainsYY");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Y", new Token(4));
        Assert.assertTrue(dict.contains("Y"));
    }

    @Test()
    public void testContainsZ() {
        System.out.println("test: testContainsZ");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertTrue(dict.contains("Z"));
    }

    @Test()
    public void testContainsZZ() {
        System.out.println("test: testContainsZZ");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Z", new Token(4));
        Assert.assertTrue(dict.contains("Z"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetNoSuchElementException() {
        System.out.println("test: testGetNoSuchElementException");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.get("V");
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetNoSuchElementExceptionNonEmpty() {
        System.out.println("test: testGetNoSuchElementExceptionNonEmpty");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.get("V");
    }

    @Test(expected = NullPointerException.class)
    public void testGetNullPointerException() {
        System.out.println("test: testGetNullPointerException");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.get(null);
    }

    @Test()
    public void testGetStatic() {
        System.out.println("test: testStatic");
        final LinkedDictionary d1 = new LinkedDictionary();
        final LinkedDictionary d2 = new LinkedDictionary();
        d1.put("X", new Token(1));
        Assert.assertFalse(d2.contains("X"));
    }

    @Test()
    public void testGetX() {
        System.out.println("test: testGetX");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertEquals(new Token(1), dict.get("X"));
    }

    @Test()
    public void testGetXX() {
        System.out.println("test: testGetXX");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("X", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("X"));
    }

    @Test()
    public void testGetY() {
        System.out.println("test: testGetY");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertEquals(new Token(2), dict.get("Y"));
    }

    @Test()
    public void testGetYY() {
        System.out.println("test: testGetYY");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Y", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("Y"));
    }

    @Test()
    public void testGetZ() {
        System.out.println("test: testGetZ");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertEquals(new Token(3), dict.get("Z"));
    }

    @Test()
    public void testGetZZ() {
        System.out.println("test: testGetZZ");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Z", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("Z"));
    }

    @Test()
    public void testPutDyncamicArray() {
        System.out.println("test: testPutDyncamicArray");
        final LinkedDictionary dict = new LinkedDictionary();
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
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put(null, new Token(1));

    }

    @Test(expected = NullPointerException.class)
    public void testPutNullPointerExceptionKeyValue() {
        System.out.println("test: testPutNullPointerExceptionKeyValue");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void testPutNullPointerExceptionValue() {
        System.out.println("test: testPutNullPointerExceptionValue");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", null);

    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveNoSuchElementException() {
        System.out.println("test: testRemoveNoSuchElementException");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.remove("V");
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveNoSuchElementExceptionNonEmpty() {
        System.out.println("test: testRemoveNoSuchElementExceptionNonEmpty");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.remove("V");
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNullPointerException() {
        System.out.println("test: testRemoveNullPointerException");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.remove(null);
    }

    @Test()
    public void testRemoveX() {
        System.out.println("test: testRemoveX");
        final LinkedDictionary dict = new LinkedDictionary();
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
        final LinkedDictionary dict = new LinkedDictionary();
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
        final LinkedDictionary dict = new LinkedDictionary();
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
        final LinkedDictionary dict = new LinkedDictionary();
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
        final LinkedDictionary dict = new LinkedDictionary();
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
        final LinkedDictionary dict = new LinkedDictionary();
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
        final LinkedDictionary dict = new LinkedDictionary();
        dict.replace("V", new Token(1));
    }

    @Test(expected = NullPointerException.class)
    public void testReplaceNullPointerExceptionKey() {
        System.out.println("test: testReplaceNullPointerExceptionKey");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.replace(null, new Token(1));

    }

    @Test(expected = NullPointerException.class)
    public void testReplaceNullPointerExceptionKeyValue() {
        System.out.println("test: testReplaceNullPointerExceptionKeyValue");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.replace(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void testReplaceNullPointerExceptionValue() {
        System.out.println("test: testReplaceNullPointerExceptionValue");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.replace("X", null);

    }

    @Test()
    public void testReplaceX() {
        System.out.println("test: testReplaceX");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.replace("X", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("X"));
    }

    @Test()
    public void testReplaceXX() {
        System.out.println("test: testReplaceXX");
        final LinkedDictionary dict = new LinkedDictionary();
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
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.replace("Y", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("Y"));
    }

    @Test()
    public void testReplaceYY() {
        System.out.println("test: testReplaceYY");
        final LinkedDictionary dict = new LinkedDictionary();
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
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.replace("Z", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("Z"));
    }

    @Test()
    public void testReplaceZZ() {
        System.out.println("test: testReplaceZZ");
        final LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Z", new Token(4));
        dict.replace("Z", new Token(5));
        Assert.assertEquals(new Token(5), dict.get("Z"));
    }

}
