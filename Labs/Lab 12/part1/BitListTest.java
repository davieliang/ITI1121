package part1;

public class BitListTest {

    public static void main(String[] args) {

        BitList a = new BitList();

        a.addFirst(0);
        a.addFirst(1);
        a.addFirst(0);
        a.addFirst(1);
        a.addFirst(0);
        a.addFirst(0);
        a.addFirst(0);

        System.out.println("a is " + a);

        BitList b = new BitList("1010111");

        System.out.println("b is " + b);

        System.out.println("compliement is " + Iterative.compliement(b));

        System.out.println("or is " + Iterative.or(a, b));

    }
}