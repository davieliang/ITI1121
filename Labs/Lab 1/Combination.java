import java.util.Arrays;

public class Combination {

    private final int[] combo;

    public Combination(final int a, final int b, final int c) {
        combo = new int[] { a, b, c };
    }

    public boolean equals(final Combination c) {
        return Arrays.equals(combo, c.combo);
    }

    @Override
    public String toString() {
        return combo[0] + ":" + combo[1] + ":" + combo[2];
    }
}