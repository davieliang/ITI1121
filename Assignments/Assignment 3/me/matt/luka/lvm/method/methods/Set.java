package me.matt.luka.lvm.method.methods;

import java.util.NoSuchElementException;

import me.matt.luka.exception.LukaSyntaxException;
import me.matt.luka.interfaces.Stack;
import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

/**
 * Implementation for the Luka instruction "Set"
 *
 * <ul>
 * <li>Classname: Set.java
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
public class Set extends LukaMethod {

    /**
     * Checks preconditions to determine if interpreter must change a definition
     *
     * @param t
     *            A token which may be an instruction
     * @param stack
     *            Reference to the Luka Virtual Machine's active stack
     * @return true if conditions are met
     */
    @Override
    public boolean canExecute(final Token t, final Stack<Token> stack) {
        if (t.getSymbol().equals("set")) {
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
     * Takes the value from the top of the stack and redefines the key specified by the next pop of the stack with that value.
     *
     * @param context
     *            Reference to MethodsContext
     */
    @Override
    public boolean execute(final MethodsContext context) {
        final Token value = context.getStack().pop();
        final String key = context.getStack().pop().getSymbol();
        try {
            context.getDictionary().replace(key, value);
        } catch (final NoSuchElementException e) {
            throw new LukaSyntaxException("Key not found: " + key);
        }
        return true;
    }

}
