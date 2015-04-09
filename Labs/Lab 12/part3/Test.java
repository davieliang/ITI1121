package part3;

public class Test {

    public static void main(String[] args) {
        LinkedList<String> xs = new LinkedList<String>();
        xs.addLast("a");
        xs.addLast("b");
        xs.addLast("c");
        xs.addLast("d");
        xs.addLast("e");
        xs.addLast("f");
        
        LinkedList<String> ys = xs.remove(0,4);
        
        System.out.println(xs);
        System.out.println(ys);

    }

}
