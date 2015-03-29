public class L7Test {

    public static void main(final String[] args) {
        final CombinationCompare c1 = new CombinationCompare(1, 2, 3);
        final CombinationCompare c2 = new CombinationCompare(1, 2, 3);
        final CombinationCompare c3 = new CombinationCompare(3, 2, 1);
        System.out.println(c1.compareTo(c2));
        System.out.println(c2.compareTo(c3));
        System.out.println(c3.compareTo(c1));

        ArrayStack<String> s;

        s = new ArrayStack<String>(10);

        for (int i = 0; i < 10; i++) {
            s.push("Elem-" + i);
        }

        s.clear();

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

        for (int i = 0; i < 10; i++) {
            s.push("** Elem-" + i);
        }

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

}
