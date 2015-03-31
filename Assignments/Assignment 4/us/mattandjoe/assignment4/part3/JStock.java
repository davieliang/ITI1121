package us.mattandjoe.assignment4.part3;

public class JStock {

	Queue<Transaction> transactions = new LinkedQueue<Transaction>();

	public void buy(int num, float sharePrice) {
		transactions.enqueue(new Transaction(num, sharePrice));
	}

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
}
