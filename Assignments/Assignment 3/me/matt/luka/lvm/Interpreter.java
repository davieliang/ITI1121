package me.matt.luka.lvm;

import java.awt.Graphics;

import me.matt.luka.lvm.method.Methods;
import me.matt.luka.wrappers.Token;

/**
 * Luka Virtual Machine (LVM) -- An interpreter for the Luka programming
 * language.
 *
 * @author Marcel Turcotte
 */
public class Interpreter extends Methods {

    /**
     * 
     */

    private Methods m;

    /**
     * Instance variable. A reference to a lexical analyzer (Reader).
     */
    private Reader r;

    /**
     * Initializes this newly created interpreter so that the operand stack is
     * empty, the accumulator is set 0, the cursor is at (0,0), and the default
     * color is blue.
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

    public void execute(String program, Graphics g) {

        r = new Reader(program);
        m.init(g);

        while (r.hasMoreTokens()) {
            Token t = r.nextToken();
            if (!m.execute(t)) {
                System.err.println("ILLEGAL TOKEN: " + t.getSymbol());
            }
        }

    }

}
