package us.mattandjoe.assignment4.part3;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import us.mattandjoe.assignment4.util.StudentInfo;

public class JStockTest {

    @BeforeClass
    public static void displayInfo() {
        StudentInfo.display("JStock");
    }

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
    public void testBuy() {
        final JStock js = new JStock();
        js.buy(100, 20);
        js.buy(20, 24);
        js.buy(200, 36);
        Assert.assertEquals(9680.0f, js.getValue(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyIllegalNumber() {
        final JStock js = new JStock();
        js.buy(-100, 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyIllegalPrice() {
        final JStock js = new JStock();
        js.buy(100, -20);
    }

    @Test()
    public void testSellAllTransactions() {
        final JStock js = new JStock();
        js.buy(100, 20);
        js.buy(20, 24);
        js.buy(200, 36);
        Assert.assertEquals(-80.0f, js.sell(320, 30), 0);
        Assert.assertEquals(0.0f, js.getValue(), 0);
    }

    @Test(expected = EmptyQueueException.class)
    public void testSellEmpty() {
        final JStock js = new JStock();
        js.sell(100, 20);
    }

    @Test()
    public void testSellExactTransaction() {
        final JStock js = new JStock();
        js.buy(100, 20);
        Assert.assertEquals(1000.0f, js.sell(100, 30), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellIllegalNumber() {
        final JStock js = new JStock();
        js.sell(-100, 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellIllegalPrice() {
        final JStock js = new JStock();
        js.sell(100, -20);
    }

    @Test()
    public void testSellOneTransaction() {
        final JStock js = new JStock();
        js.buy(100, 20);
        js.buy(20, 24);
        js.buy(200, 36);
        Assert.assertEquals(500.0f, js.sell(50, 30), 0);
    }

    @Test()
    public void testSellOverTransactions() {
        final JStock js = new JStock();
        js.buy(100, 20);
        js.buy(20, 24);
        js.buy(200, 36);
        Assert.assertEquals(-80.0f, js.sell(321, 30), 0);
        Assert.assertEquals("You have ran out of shares to sell!", out
                .toString().trim());
        Assert.assertEquals(0.0f, js.getValue(), 0);
    }

    @Test()
    public void testSellSomeTransactions() {
        final JStock js = new JStock();
        js.buy(100, 20);
        js.buy(20, 24);
        js.buy(200, 36);
        Assert.assertEquals(940.0f, js.sell(150, 30), 0);
    }

    @Test()
    public void testValue() {
        final JStock js = new JStock();
        js.buy(100, 20);
        Assert.assertEquals(2000.0f, js.getValue(), 0);
    }
}
