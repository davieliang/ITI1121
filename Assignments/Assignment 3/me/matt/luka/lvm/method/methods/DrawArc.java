package me.matt.luka.lvm.method.methods;

import me.matt.luka.exception.LukaSyntaxException;
import me.matt.luka.interfaces.Stack;
import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;
/**
 * Implementation for the Luka instruction "DrawArc"
 * 
 * <ul>
 * <li>Classname: DrawArc.java
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
public class DrawArc extends LukaMethod {

	/**
	 * Checks preconditions to determine if interpreter should draw an arc
	 * @param t A token which may be an instruction
	 * @param stack Reference to the Luka Virtual Machine's active stack
	 * @return true if conditions are met
	 */
    @Override
    public boolean canExecute(final Token t, final Stack<Token> stack) {
        if (t.getSymbol().equalsIgnoreCase("arc")) {
            if (stack.size() > 2) {
                if (stack.peek().isNumber() && stack.peek(1).isNumber()
                        && stack.peek(2).isNumber()) {
                    return true;
                }
                throw new LukaSyntaxException(
                        "The last two elements in the stack must be numbers");
            }
            throw new LukaSyntaxException("Stack of size 3 or more is required");
        } else {
            return false;
        }
    }

	/**
	 * Draws an arc from current cursor position to position x,y specified by last two elements of the stack and
	 * of radius r specified by third element of the stack
	 * @param context reference to MethodsContext
	 */
    @Override
    public boolean execute(final MethodsContext context) {
        final Token a2 = context.getStack().pop();
        final Token a1 = context.getStack().pop();
        final Token r = context.getStack().pop();
        context.getGraphics().drawArc((int) context.getCursorPosition().getX(),
                (int) context.getCursorPosition().getY(), r.getNumber(),
                r.getNumber(), a1.getNumber(), a2.getNumber());
        return true;
    }

}
