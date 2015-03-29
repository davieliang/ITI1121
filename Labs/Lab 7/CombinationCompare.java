import java.util.Arrays;

public class CombinationCompare implements Comparable<CombinationCompare> {

    private final int[] combo;

    public CombinationCompare(final int a, final int b, final int c) {
        combo = new int[] { a, b, c };
    }

    @Override
    public int compareTo(final CombinationCompare o) {
        if (o == null) {
            return -1;
        }
        return this.equals(o) ? 0 : ((combo[0] > o.combo[0]) ? 1
                : ((combo[1] > o.combo[1]) ? ((combo[2] > o.combo[2]) ? 1 : -1)
                        : -1));
    }

    public boolean equals(final CombinationCompare c) {
        return Arrays.equals(combo, c.combo);
    }

    @Override
    public String toString() {
        return combo[0] + ":" + combo[1] + ":" + combo[2];
    }
}