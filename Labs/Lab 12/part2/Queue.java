package part2;
public interface Queue<E> {
    public abstract boolean isEmpty();
    public abstract void enqueue(E value);
    public abstract E dequeue();
}

    