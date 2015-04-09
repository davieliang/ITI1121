package part2;

public interface QueueIterator<E> {
    
    public abstract boolean hasNext();

    public abstract E next();
}