package us.mattandjoe.assignment4.part3;

public class Transaction {

	private int shares;
	private float sharePrice;

	public Transaction(int shares, float sharePrice) {
		this.shares = shares;
		this.sharePrice = sharePrice;
	}

	public int getShares() {
		return shares;
	}

	public void sell(int num) {
		if (num > shares) {
			throw new IllegalArgumentException("can't sell more than you have");
		}
		shares = shares - num;
	}

	public float getSharePrice() {
		return sharePrice;
	}

}
