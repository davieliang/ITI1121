package me.matt.luka.lvm;

import java.util.StringTokenizer;

import me.matt.luka.wrappers.Token;

/**
 * The class <code>Reader</code> implements the <b>lexical analysis</b> of our
 * <b>Luka</b> programs so that you do not have to be concerned by details, such
 * as skipping white spaces, when implementing the interpreter. The intended use
 * of the <code>Reader</code> follows:
 *
 * <pre>
 * Reader r = new Reader(program);
 * 
 * while (r.hasMoreTokens()) {
 *     Token t = r.nextToken();
 * 
 *     if (!t.isSymbol()) {
 *         // ...
 *     } else if (t.sValue().equals(&quot;plus&quot;)) {
 *         // ...
 *     }
 * }
 * </pre>
 *
 * @see StringTokenizer
 * @author Marcel Turcotte
 *
 *         <ul>
 *         <li>Classname: Reader.java
 *         <li>23-03-2015
 *         <li>Assignment 3
 *         <li>Course: IT1 1121 A
 *         <li>Langlois, Matt
 *         <li>Student number: 7731813
 *         <li>Faubert, Joel
 *         <li>Student number: 2560106
 *         </ul>
 *
 */
public class Reader {

    /**
     * Instance variable. Reader uses a StringTokenizer for the lexical
     * analysis.
     */
    private final StringTokenizer st;

    /**
     * Create a Reader object for the parameter string.
     *
     * @param s
     *            the expression to be analyzed.
     */
    public Reader(final String s) {
        st = new StringTokenizer(s);
    }

    /**
     * Tests if the end of the program has been reached.
     *
     * @return true if the Reader has reached the end of the input (program).
     */
    public boolean hasMoreTokens() {
        return st.hasMoreTokens();
    }

    /**
     * Reads and returns the next token.
     *
     * @return The next Token from the input.
     */
    public Token nextToken() {

        final String t = st.nextToken();

        try {
            return new Token(Integer.parseInt(t));
        } catch (final NumberFormatException e) {
            return new Token(t);
        }

    }

}
