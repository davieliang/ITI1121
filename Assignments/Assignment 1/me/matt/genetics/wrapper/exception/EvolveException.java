package me.matt.genetics.wrapper.exception;

public class EvolveException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -683148991150680538L;

    /**
     * Evolution exception
     *
     * @param error
     *            Error message.
     */
    public EvolveException(final String error) {
        super(error);
    }

}
