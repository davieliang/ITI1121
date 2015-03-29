package me.matt.luka.lvm;

import java.awt.Graphics;

import me.matt.luka.lvm.method.Methods;
import me.matt.luka.wrappers.Token;

/**
 * Luka Virtual Machine (LVM) -- An interpreter for the Luka programming
 * language.
 *
 * <ul>
 * <li>Classname: Interpreter.java
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
 *
 */
public class Interpreter extends Methods {

    /**
     * An instance of methods which can be executed by the interpreter
     */
    private final Methods m;

    /**
     * Instance variable. A reference to a lexical analyzer (Reader).
     */
    private Reader r;

    /**
     * Initializes this newly created interpreter so that the operand stack is
     * empty, the cursor is set to (0,0) and the methods are initialized
     */
    public Interpreter() {
        m = new Methods();
    }

    /**
     * Executes the input program and displays the result onto the Graphics
     * object received as an argument.
     *
     * @param program
     *            contains the source to be executed.
     * @param g
     *            the graphics context.
     */

    public void execute(final String program, final Graphics g) {

        /*
         * Reads the luka code
         */
        r = new Reader(program);

        /*
         * Initializes the methods class with the graphics canvas to draw
         */
        m.init(g);

        while (r.hasMoreTokens()) {
            final Token t = r.nextToken();

            /*
             * Execute the requirement for the symbol
             */
            m.execute(t);
        }
        System.out.println();// Create a padding for execution between two programs
    }

}
