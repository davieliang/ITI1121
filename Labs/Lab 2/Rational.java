public class Rational {

    public static void main(String[] args) {
        System.out.println(new Rational(5, 4).compareTo(new Rational(4, 4)));
    }

    private int numerator;
    private int denominator;

    public Rational(final int numerator) {
        this(numerator, 1);
    }

    public Rational(final int numerator, final int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce();
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Rational plus(final Rational rational) {
        if (rational == null) {
            throw new NullPointerException("Rational expected, null given.");
        }
        int denominator = this.denominator * rational.getDenominator();
        Rational added = new Rational(
                (this.numerator * rational.getDenominator())
                        + (this.denominator * rational.getNumerator()),
                denominator);
        added.reduce();
        return added;
    }

    public boolean equals(final Rational rational) {
        return rational == null ? false : rational.getNumerator() == numerator
                && rational.getDenominator() == denominator;
    }

    public String toString() {
        return numerator + (denominator == 1 ? "" : "/" + denominator);
    }

    public int compareTo(Rational rational) {
        if (rational == null) {
            throw new NullPointerException("Rational expected, null given.");
        }
        double d = ((double) this.numerator / (double) this.denominator)
                - ((double) rational.getNumerator() / (double) rational
                        .getDenominator());
        return (int) (d < 0 ? Math.floor(d) : Math.ceil(d));
    }

    private void reduce() {
        int tmp = numerator;
        this.numerator = numerator / gcd(numerator, denominator);
        this.denominator = denominator / (gcd(tmp, denominator));
    }

    private static int gcd(final int one, final int two) {
        return two == 0 ? one : gcd(two, one % two);
    }

    /**
     * Adds two <code>Rational</code> numbers together.
     * 
     * @param one
     *            The first rational number
     * @param two
     *            The second rational number
     * @return A <code>Rational</code> representing the addition of <code>one</code> and
     *         <code>two</code>
     */
    public static Rational plus(final Rational one, final Rational two) {
        if (one == null || two == null) {
            throw new NullPointerException("Rational expected, null given.");
        }
        return one.plus(two);
    }

}
