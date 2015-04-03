package us.mattandjoe.assignment4.part4;

public class Tuple {

    private final char c;
    private boolean visited;

    public Tuple(final char c) {
        this.c = c;
        visited = false;
    }

    public char getChar() {
        return c;
    }

    public void toggle() {
        visited = !visited;
    }

    @Override
    public String toString() {
        if (visited) {
            return "(" + c + ",t)";
        } else {
            return "(" + c + ",f)";
        }
    }

    public boolean visited() {
        return visited;
    }
}
