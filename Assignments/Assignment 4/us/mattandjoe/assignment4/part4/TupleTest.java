package us.mattandjoe.assignment4.part4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TupleTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test()
    public void testList() {
        List<Tuple> l = new LinkedList<Tuple>();

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

    @Test()
    public void testEmpty() {
        List<Tuple> l = new LinkedList<Tuple>();
        Frequency.frequency(l);
        Assert.assertEquals("Empty", out.toString().trim());
    }

    @Test(expected = NullPointerException.class)
    public void testNull() {
        Frequency.frequency(null);
    }
}
