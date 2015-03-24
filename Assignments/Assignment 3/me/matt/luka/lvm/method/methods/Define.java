package me.matt.luka.lvm.method.methods;

import me.matt.luka.exception.LukaSyntaxException;
import me.matt.luka.interfaces.Stack;
import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

/**
 * Implementation for the Luka instruction "Define"
 *
 * <ul>
 * <li>Classname: Define.java
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
public class Define extends LukaMethod {

    /**
     * Checks preconditions to determine if interpreter should define a new association in the dictionary
     * 
     * @param t
     *            A token which may be an instruction
     * @param stack
     *            Reference to the Luka Virtual Machine's active stack
     * @return true if conditions are met
     */
    @Override
    public boolean canExecute(final Token t, final Stack<Token> stack) {
        if (t.getSymbol().equals("def")) {
            if (stack.size() > 1) {
                if (stack.peek(1).isSymbol()) {
                    if (stack.peek().isNumber()) {
                        return true;
                    }
                    throw new LukaSyntaxException(
                            "The value should be a number");
                }
                throw new LukaSyntaxException("The variable should be a symbol");
            }
            throw new LukaSyntaxException(
                    "Stack of size 2 or more is required to define a variable");
        } else {
            return false;
        }
    }

    /**
     * Adds a new association to the dictionary
     * 
     * @param context
     *            reference to MethodsContext
     */
    @Override
    public boolean execute(final MethodsContext context) {
        final Token number = context.getStack().pop();
        final Token variable = context.getStack().pop();
        context.getDictionary().put(variable.getSymbol(), number);
        return true;
    }

}
