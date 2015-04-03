package us.mattandjoe.assignment4.part5;

public class Test {

    public static void main(final String[] args) {

        SinglyLinkedList<String> l;
        l = new SinglyLinkedList<String>();

        l.addFirst("A");
        l.addFirst("D");
        l.addFirst("C");
        l.addFirst("A");
        l.addFirst("A");
        l.addFirst("B");
        l.addFirst("A");

        final String list = l.toString();
        final String allIndex = l.indexOfAll("A").toString();

        System.out.println(l);
        System.out.println(allIndex);

        assert list.equals("{A,B,A,A,C,D,A}");
        assert allIndex.equals("{0,2,3,6}");
    }

}
