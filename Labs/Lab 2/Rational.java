public class Rational {

    private static int gcd(final int one, final int two) {
        return two == 0 ? one : Rational.gcd(two, one % two);
    }

    public static void main(final String[] args) {
        System.out.println(new Rational(5, 0).compareTo(new Rational(4, 4)));
    }

    /**
     * Adds two <code>Rational</code> numbers together.
     *
     * @param one
     *            The first rational number
     * @param two
     *            The second rational number
     * @return A <code>Rational</code> representing the addition of <code>one</code> and <code>two</code>
     */
    public static Rational plus(final Rational one, final Rational two) {
        if (one == null || two == null) {
            throw new NullPointerException("Rational expected, null given.");
        }
        return one.plus(two);
    }

    private int numerator;

    private int denominator;

    public Rational(final int numerator) {
        this(numerator, 1);
    }

    public Rational(final int numerator, final int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("denominator cannot be zero");
        }
        this.numerator = numerator < 0 ? Math.abs(numerator) : numerator;
        this.denominator = numerator < 0 ? denominator * -1 : denominator;
        this.reduce();
    }

    public int compareTo(final Rational rational) {
        if (rational == null) {
            throw new NullPointerException("Rational expected, null given.");
        }
        final double d = ((double) numerator / (double) denominator)
                - ((double) rational.getNumerator() / (double) rational
                        .getDenominator());
        return (int) (d < 0 ? Math.floor(d) : Math.ceil(d));
    }

    public boolean equals(final Rational rational) {
        return rational == null ? false : rational.getNumerator() == numerator
                && rational.getDenominator() == denominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public Rational plus(final Rational rational) {
        if (rational == null) {
            throw new NullPointerException("Rational expected, null given.");
        }
        final int denominator = this.denominator * rational.getDenominator();
        final Rational added = new Rational(
                (numerator * rational.getDenominator())
                        + (this.denominator * rational.getNumerator()),
                denominator);
        added.reduce();
        return added;
    }

    private void reduce() {
        final int tmp = numerator;
        numerator = numerator / Rational.gcd(numerator, denominator);
        denominator = denominator / (Rational.gcd(tmp, denominator));
    }

    @Override
    public String toString() {
        return numerator + (denominator == 1 ? "" : "/" + denominator);
    }

}
