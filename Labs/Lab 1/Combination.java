import java.util.Arrays;

public class Combination {

    private int[] combo;

    public Combination(final int a, final int b, final int c) {
        this.combo = new int[] { a, b, c };
    }

    public boolean equals(Combination c) {
        return Arrays.equals(this.combo, c.combo);
    }

    public String toString() {
        return combo[0] + ":" + combo[1] + ":" + combo[2];
    }
}