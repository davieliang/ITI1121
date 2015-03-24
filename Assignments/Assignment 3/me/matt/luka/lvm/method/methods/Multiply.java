package me.matt.luka.lvm.method.methods;

import me.matt.luka.exception.LukaSyntaxException;
import me.matt.luka.interfaces.Stack;
import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

/**
 * Implementation for the Luka instruction "Multiply"
 *
 * <ul>
 * <li>Classname: Multiply.java
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
public class Multiply extends LukaMethod {

    /**
     * Checks preconditions to determine if interpreter should multiply
     * 
     * @param t
     *            A token which may be an instruction
     * @param stack
     *            Reference to the Luka Virtual Machine's active stack
     * @return true if conditions are met
     */
    @Override
    public boolean canExecute(final Token t, final Stack<Token> stack) {
        if (t.getSymbol().equalsIgnoreCase("mul")) {
            if (stack.size() > 1) {
                if (stack.peek().isNumber() && stack.peek(1).isNumber()) {
                    return true;
                }
                throw new LukaSyntaxException(
                        "The last two elements in the stack must be numbers");
            }
            throw new LukaSyntaxException("Stack of size 2 or more is required");
        } else {
            return false;
        }
    }

    /**
     * Pops two numbers from the stack, multiples the first and the second, and pushes the results to the stack
     * 
     * @param context
     *            Reference to MethodsContext
     */
    @Override
    public boolean execute(final MethodsContext context) {
        final Token op1 = context.getStack().pop();
        final Token op2 = context.getStack().pop();
        final Token res = new Token(op1.getNumber() * op2.getNumber());
        context.getStack().push(res);
        return true;
    }

}
