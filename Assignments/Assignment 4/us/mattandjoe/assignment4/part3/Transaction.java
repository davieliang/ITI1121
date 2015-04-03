package us.mattandjoe.assignment4.part3;

/**
 * Stores information about the purchase of shares
 *
 * @author Marcel Turcotte
 *
 *         <ul>
 *         <li>Classname: Transaction.java
 *         <li>31-03-2015
 *         <li>Assignment 4
 *         <li>Course: IT1 1121 A
 *         <li>Langlois, Matt
 *         <li>Student number: 7731813
 *         <li>Faubert, Joel
 *         <li>Student number: 2560106
 *         </ul>
 */
public class Transaction {

    private int shares; // number of shares
    private final float sharePrice; // purchase price

    /**
     * Constructor
     * 
     * @param shares
     *            number of shares
     * @param sharePrice
     *            purchase price
     */
    public Transaction(final int shares, final float sharePrice) {
        this.shares = shares;
        this.sharePrice = sharePrice;
    }

    /**
     * Returns purchase price of shares
     * 
     * @return purchase price of shares
     */
    public float getSharePrice() {
        return sharePrice;
    }

    /**
     * Returns number of shares
     * 
     * @return number of shares
     */
    public int getShares() {
        return shares;
    }

    /**
     * Decrements shares by sold amount
     * 
     * @param num
     *            number shares sold
     */
    public void sell(final int num) {
        if (num > shares) {
            throw new IllegalArgumentException("Can't sell more than you have");
        }
        shares = shares - num;
    }

}
