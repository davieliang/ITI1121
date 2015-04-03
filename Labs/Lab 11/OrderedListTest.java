import org.junit.Test;

public class OrderedListTest {
    @Test(expected = NullPointerException.class)
    public void testAddNull() {
        final OrderedList<String> list = new OrderedList<String>();
        list.add(null);
    }

    @Test()
    public void testAdd() {
        final OrderedList<Integer> list = new OrderedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);
        System.out.println(list.toString());
    }
}
