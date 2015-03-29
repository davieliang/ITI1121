package me.matt.luka.lvm.method.methods;

import java.awt.Color;
import java.lang.reflect.Field;

import me.matt.luka.exception.LukaSyntaxException;
import me.matt.luka.interfaces.Stack;
import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

/**
 * Implementation for the Luka instruction "SetColour"
 *
 * <ul>
 * <li>Classname: SetColour.java
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
public class SetColour extends LukaMethod {

    /**
     * Checks preconditions to determine if interpreter should change colour for drawing
     *
     * @param t
     *            A token which may be an instruction
     * @param stack
     *            Reference to the Luka Virtual Machine's active stack
     * @return true if conditions are met
     */
    @Override
    public boolean canExecute(final Token t, final Stack<Token> stack) {
        if (t.getSymbol().equalsIgnoreCase("setcolour")
                && !stack.peek().isSymbol()) {
            throw new LukaSyntaxException(
                    "Expected a symbol; recieved a number");
        }
        return t.getSymbol().equalsIgnoreCase("setcolour");
    }

    /**
     * Changes the colour for drawing graphics
     *
     * @param context
     *            Reference to MethodsContext
     */
    @Override
    public boolean execute(final MethodsContext context) {
        final String colour = context.getStack().pop().getSymbol();
        context.getGraphics().setColor(this.findColour(colour));
        return false;
    }

    private Color findColour(final String colour) {
        /*
         * Find all field in the colour class
         */
        for (final Field f : Color.class.getFields()) {
            try {
                /*
                 * If the field is a valid colour object and the name of the field is the name of the color specified, return it's instance
                 */
                if (f.getType() == Color.class
                        && f.getName().equalsIgnoreCase(colour)) {
                    return (Color) f.get(null);
                }
            } catch (final IllegalAccessException e) {
                // Colour should always exist and be accessible
            }
        }
        throw new LukaSyntaxException("Colour " + colour + " not supported");
    }

}
