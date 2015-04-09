package part2;

public class Test {
    
    public static void main(String[] args) {
        CircularQueue<String> queue = new CircularQueue<String>(7);
        queue.enqueue("A");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        queue.enqueue("g");
        
        QueueIterator<String> i = queue.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        QueueIterator<String> j = queue.iterator();
        while (j.hasNext()) {
            System.out.println(j.next());
        }
        System.out.println("Error expected");
        i.next();
    }

}
