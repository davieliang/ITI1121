package us.mattandjoe.assignment4.part3;

public class JStockTest {
    /**
     * Test cases
     * 
     * @param args
     *            command line params unused
     */
    public static void main(String[] args) {
        /*
         * Data points for test: Yahoo inc. prices at market close
         * 
         * Purchase times
         * Date Price
         * DD-MM-YYYY USD
         * 01-10-2014 40.32
         * 03-11-2014 46.34
         * 01-12-2014 50.10
         * 02-01-2015 50.17
         * 02-02-2015 44.69
         * 02-03-2015 44.11
         * 
         * Sale point:
         * 31-03-2015 44.44
         */
        JStock testYahoo = new JStock();
        testYahoo.buy(100, 40.32f);
        testYahoo.buy(100, 46.34f);
        testYahoo.buy(100, 50.10f);
        testYahoo.buy(100, 50.17f);
        testYahoo.buy(100, 44.69f);
        testYahoo.buy(100, 44.11f);
        System.out.println(testYahoo.getValue());
        System.out.println(testYahoo.sell(600, 44.44f)); // You would lose capital gains.
    }
}
