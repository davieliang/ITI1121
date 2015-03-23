package me.matt.luka.exception;

/**
 * An object of the class <code>EmptyStackException</code> is thrown by the
 * methods of a <code>Stack</code> to indicate the illegal situations where a
 * stack was empty.
 */
public class EmptyStackException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 831138896625089171L;

    public EmptyStackException() {
    }

    public EmptyStackException(final String message) {
        super(message);
    }

}
