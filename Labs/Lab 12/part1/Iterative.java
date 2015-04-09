package part1;

public class Iterative {
    public static BitList compliement(BitList bl) {
        return new BitList(bl.toString().replace("1", "2").replace("0", "1")
                .replace("2", "0"));
    }

    public static BitList or(BitList bl1, BitList bl2) {
        if (bl2.toString().length() == 0 || bl1.toString().length() == 0
                || bl1.toString().length() != bl2.toString().length()) {
            throw new IllegalArgumentException();
        }
        BitList bl = new BitList();
        Iterator k = bl.iterator();
        Iterator i = bl1.iterator();
        Iterator j = bl2.iterator();
        while (i.hasNext() && j.hasNext()) {
            k.add(i.next() | j.next());
        }
        return bl;
    }
}
