/*
 * ITI 1121. Introduction to Computing II; Laboratory 2
 * ITI 1521. Introduction a l'informatique II; Laboratoire 2
 */

/**
 * A series of tests for the method findAndReplace.
 *
 * @author Marcel Turcotte (turcotte@site.uottawa.ca)
 */

import junit.framework.Assert;
import junit.framework.TestCase;

@SuppressWarnings("deprecation")
public class TestFindAndReplace extends TestCase {

    public static void testAllNull() {
        Assert.assertNull(Utils.findAndReplace(null, null, null));
    }

    public static void testChangeFirst1() {
        final String[] text = { "I", "understand" };
        final String[] query = { text[0] };
        final String[] replacement = { "You" };
        final String[] expected = { replacement[0], text[1] };
        final String[] result = Utils.findAndReplace(text, query, replacement);
        Assert.assertNotNull(result);
        Assert.assertFalse(text == result);
        Assert.assertTrue(text.length == result.length);
        for (int i = 0; i < text.length; i++) {
            Assert.assertEquals(expected[i], result[i]);
        }
    }

    public static void testChangeFirst2() {
        final String[] text = { "I", "understand" };
        final String[] query = { new String("I") };
        final String[] replacement = { "You" };
        final String[] expected = { "You", "understand" };
        final String[] result = Utils.findAndReplace(text, query, replacement);
        Assert.assertNotNull(result);
        Assert.assertFalse(text == result);
        Assert.assertTrue(text.length == result.length);
        for (int i = 0; i < text.length; i++) {
            Assert.assertEquals(expected[i], result[i]);
        }
    }

    public static void testChangeLast() {
        final String[] text = { "I", "understand" };
        final String[] query = { new String("understand") };
        final String[] replacement = { "see" };
        final String[] expected = { "I", "see" };
        final String[] result = Utils.findAndReplace(text, query, replacement);
        Assert.assertNotNull(result);
        Assert.assertFalse(text == result);
        Assert.assertTrue(text.length == result.length);
        for (int i = 0; i < text.length; i++) {
            Assert.assertEquals(expected[i], result[i]);
        }
    }

    public static void testChangeLeft() {
        final String[] text = { "I", "understand" };
        final String[] query = { new String("understand"),
                new String("understand") };
        final String[] replacement = { "see", "grasp" };
        final String[] expected = { "I", "see" };
        final String[] result = Utils.findAndReplace(text, query, replacement);
        Assert.assertNotNull(result);
        Assert.assertFalse(text == result);
        Assert.assertTrue(text.length == result.length);
        for (int i = 0; i < text.length; i++) {
            Assert.assertEquals(expected[i], result[i]);
        }
    }

    public static void testInAndQueryAreNull() {
        final String[] replacement = { "You" };
        Assert.assertNull(Utils.findAndReplace(null, null, replacement));
    }

    public static void testInAndReplacementreNull() {
        final String[] query = { "I" };
        Assert.assertNull(Utils.findAndReplace(null, query, null));
    }

    public static void testInIsNull() {
        final String[] query = { "I" };
        final String[] replacement = { "You" };
        Assert.assertNull(Utils.findAndReplace(null, query, replacement));
    }

    public static void testInIsUnchanged() {
        final String[] text = { "I", "like", "Java" };
        final String[] query = { new String("I"), new String("Java"),
                new String("like") };
        final String[] replacement = { "You", "object-oriented programming",
                "enjoy" };
        final String[] expected = new String[text.length];
        System.arraycopy(text, 0, expected, 0, text.length);
        final String[] result = Utils.findAndReplace(text, query, replacement);
        Assert.assertNotNull(result);
        Assert.assertFalse(text == result);
        Assert.assertTrue(text.length == result.length);
        for (int i = 0; i < text.length; i++) {
            Assert.assertEquals(expected[i], text[i]);
        }
    }

    public static void testMultipleChanges1() {
        final String[] text = { "I", "like", "Java" };
        final String[] query = { new String("I"), new String("like"),
                new String("Java") };
        final String[] replacement = { "You", "enjoy",
                "object-oriented programming" };
        final String[] expected = { "You", "enjoy",
                "object-oriented programming" };
        final String[] result = Utils.findAndReplace(text, query, replacement);
        Assert.assertNotNull(result);
        Assert.assertFalse(text == result);
        Assert.assertTrue(text.length == result.length);
        for (int i = 0; i < text.length; i++) {
            Assert.assertEquals(expected[i], result[i]);
        }
    }

    public static void testMultipleChanges2() {
        final String[] text = { "I", "like", "Java" };
        final String[] query = { new String("I"), new String("Java"),
                new String("like") };
        final String[] replacement = { "You", "object-oriented programming",
                "enjoy" };
        final String[] expected = { "You", "enjoy",
                "object-oriented programming" };
        final String[] result = Utils.findAndReplace(text, query, replacement);
        Assert.assertNotNull(result);
        Assert.assertFalse(text == result);
        Assert.assertTrue(text.length == result.length);
        for (int i = 0; i < text.length; i++) {
            Assert.assertEquals(expected[i], result[i]);
        }
    }

    public static void testNoChange1() {
        final String[] text = { "I", "understand" };
        final String[] query = {};
        final String[] replacement = {};
        final String[] result = Utils.findAndReplace(text, query, replacement);
        Assert.assertNotNull(result);
        Assert.assertFalse(text == result);
        Assert.assertTrue(text.length == result.length);
        for (int i = 0; i < text.length; i++) {
            Assert.assertEquals(text[i], result[i]);
        }
    }

    public static void testNoChange2() {
        final String[] text = { "I", "understand" };
        final String[] query = { "You" };
        final String[] replacement = { "I" };
        final String[] result = Utils.findAndReplace(text, query, replacement);
        Assert.assertNotNull(result);
        Assert.assertFalse(text == result);
        Assert.assertTrue(text.length == result.length);
        for (int i = 0; i < text.length; i++) {
            Assert.assertEquals(text[i], result[i]);
        }
    }

    public static void testNotSameLength() {
        final String[] text = { "I", "understand" };
        final String[] query = { "I" };
        final String[] replacement = { "You", "They" };
        Assert.assertNull(Utils.findAndReplace(text, query, replacement));
    }

    public static void testNullInIn() {
        final String[] text = { "I", null };
        final String[] query = { "I" };
        final String[] replacement = { "You" };
        Assert.assertNull(Utils.findAndReplace(text, query, replacement));
    }

    public static void testNullInQuery() {
        final String[] text = { "I", "understand" };
        final String[] query = { "I", null };
        final String[] replacement = { "You", "They" };
        Assert.assertNull(Utils.findAndReplace(text, query, replacement));
    }

    public static void testNullInReplacement() {
        final String[] text = { "I", "understand" };
        final String[] query = { "I", "We" };
        final String[] replacement = { null, "They" };
        Assert.assertNull(Utils.findAndReplace(text, query, replacement));
    }

    public static void testQueryAndReplacementreNull() {
        final String[] text = { "I", "understand" };
        Assert.assertNull(Utils.findAndReplace(text, null, null));
    }

    public static void testQueryIsNull() {
        final String[] text = { "I", "understand" };
        final String[] replacement = { "You" };
        Assert.assertNull(Utils.findAndReplace(text, null, replacement));
    }

    public static void testReplacementIsNull() {
        final String[] text = { "I", "understand" };
        final String[] query = { "I" };
        Assert.assertNull(Utils.findAndReplace(text, query, null));
    }

}