package part1;
// Our own interface Iterator where next returns an int!

public interface Iterator {
    public abstract boolean hasNext();

    public abstract int next();

    public abstract void add(int bit);
}