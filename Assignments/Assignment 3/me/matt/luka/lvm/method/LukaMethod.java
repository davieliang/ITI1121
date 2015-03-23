package me.matt.luka.lvm.method;

import me.matt.luka.interfaces.Stack;
import me.matt.luka.wrappers.Token;

/**
 * An abstract class representing a Luka function which can be called by the Luka Virtual Machine
 * 
 * <ul>
 * <li>Classname: LukaMethod.java
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
public abstract class LukaMethod {

    /**
     * 
     * @param token
     *            The current token being evaluated
     * @param stack
     *            The current state of the stack
     * @return True if this method should be executed
     */
    public abstract boolean canExecute(Token token, Stack<Token> stack);

    /**
     * Executes the luka method
     * 
     * @param context
     *            The method's context containing all of the accessable variables
     * @return true if the method was executed successfuly
     */
    public abstract boolean execute(MethodsContext context);

}
