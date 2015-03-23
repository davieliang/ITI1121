package me.matt.luka.lvm.method;

import me.matt.luka.interfaces.Stack;
import me.matt.luka.wrappers.Token;

/**
 * An abstract class represnting a luka function which can be called by the luka virtual machine
 * 
 * @author Matt
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
