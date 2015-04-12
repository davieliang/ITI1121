package us.mattandjoe.assignment4.part4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * A unit test of the Tuple frequency
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
public class TupleTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(out));
    }

    @Test()
    public void testEmpty() {
        final List<Tuple> l = new LinkedList<Tuple>();
        Frequency.frequency(l);
        Assert.assertEquals("Empty", out.toString().trim());
    }

    @Test()
    public void testList() {
        final List<Tuple> l = new LinkedList<Tuple>();

        l.add(new Tuple('a'));
        l.add(new Tuple('b'));
        l.add(new Tuple('a'));
        l.add(new Tuple('c'));
        l.add(new Tuple('b'));
        l.add(new Tuple('a'));
        l.add(new Tuple('c'));
        l.add(new Tuple('a'));
        l.add(new Tuple('d'));
        l.add(new Tuple('d'));
        l.add(new Tuple('b'));
        Frequency.frequency(l);
        Assert.assertEquals("a : 4, b : 3, c : 2, d : 2", out.toString().trim());
    }

    @Test(expected = NullPointerException.class)
    public void testNull() {
        Frequency.frequency(null);
    }
}
