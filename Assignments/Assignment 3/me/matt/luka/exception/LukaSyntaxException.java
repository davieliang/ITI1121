package me.matt.luka.exception;

public class LukaSyntaxException extends RuntimeException {

    /**
     * Special type of RunTimeException to handle incorrect Luka commands
     *
     * <ul>
     * <li>Classname: LukaSyntaxException.java
     * <li>23-03-2015
     * <li>Assignment 3
     * <li>Course: IT1 1121 A
     * <li>Langlois, Matt
     * <li>Student number: 7731813
     * <li>Faubert, Joel
     * <li>Student number: 2560106
     * </ul>
     *
     * @author Matt Langlois
     * @author Joel Faubert
     * @version 1
     *
     */
    private static final long serialVersionUID = -7178834042927850690L;

    public LukaSyntaxException(final String message) {
        super(message);
    }

}
