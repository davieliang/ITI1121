package us.mattandjoe.assignment4.part3;

/**
 * Class uses a queue to store the transactions of a given stock.
 * Facilitates calculations of capital gains and losses when selling shares.
 *
 * <ul>
 * <li>Classname: JStock.java
 * <li>31-03-2015
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
public class JStock {

    Queue<Transaction> transactions = new LinkedQueue<Transaction>(); // Queue used to store the order in which shares were purchased

    /**
     * Logs the purchase of shares and adds it to the end of the transactions queue.
     *
     * @param num
     *            number of shares purchased
     * @param sharePrice
     *            purchase price of shares
     */
    public void buy(final int num, final float sharePrice) {
        transactions.enqueue(new Transaction(num, sharePrice));
    }

    /**
     * Calculates the value of a stock portfolio
     *
     * @return total value of shares in a portfolio
     */
    public float getValue() {
        float result = 0;
        final Queue<Transaction> tmp = new LinkedQueue<Transaction>();
        Transaction t;
        while (!transactions.isEmpty()) {
            t = transactions.dequeue();
            result = t.getSharePrice() * t.getShares();
            tmp.enqueue(t);
        }
        while (!tmp.isEmpty()) {
            transactions.enqueue(tmp.dequeue());
        }
        return result;
    }

    /**
     * Calculates the capital gains/losses involved in selling a certain number of shares.
     * Sells oldest shares first.
     *
     * @param num
     *            number of shares to sell
     * @param sharePrice
     *            sell price of shares
     * @return profits/losses made
     */
    public float sell(int num, final float sharePrice) {
        if (transactions.isEmpty()) {
            throw new EmptyQueueException("Can't sell empty portfolio.");
        }

        float result = 0;
        Transaction t;

        while (num != 0 && !transactions.isEmpty()) {
            if (transactions.peek().getShares() > num) {
                result += (sharePrice - transactions.peek().getSharePrice())
                        * num;
                transactions.peek().sell(num);
                num = 0;
            } else {
                t = transactions.dequeue();
                result += (sharePrice - t.getSharePrice()) * num;
                num -= t.getShares();
            }
        }
        return result;
    }
}
