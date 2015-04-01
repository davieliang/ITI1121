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
	 * @param num number of shares purchased
	 * @param sharePrice purchase price of shares
	 */
	public void buy(int num, float sharePrice) {
		transactions.enqueue(new Transaction(num, sharePrice));
	}

	/**
	 * Calculates the capital gains/losses involved in selling a certain number of shares.
	 * Sells oldest shares first.
	 * @param num number of shares to sell
	 * @param sharePrice sell price of shares
	 * @return profits/losses made
	 */
	public float sell(int num, float sharePrice) {
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

	/**
	 * Calculates the value of a stock portfolio
	 * @return total value of shares in a portfolio
	 */
	public float getValue() {
		float result = 0;
		Queue<Transaction> tmp = new LinkedQueue<Transaction>();
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
	 * Test cases
	 * @param args command line params unused
	 */
	public static void main(String[] args) {
		/*
		 * Data points for test: Yahoo inc. prices at market close
		 * 
		 * Purchase times
		 *  Date			Price
		 *  DD-MM-YYYY		USD
		 *  01-10-2014		40.32
		 *  03-11-2014		46.34
		 *  01-12-2014		50.10
		 *  02-01-2015		50.17
		 *  02-02-2015		44.69
		 *  02-03-2015		44.11
		 *  
		 *  Sale point:
		 *  31-03-2015		44.44
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
