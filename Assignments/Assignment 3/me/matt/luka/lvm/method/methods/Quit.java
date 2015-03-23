package me.matt.luka.lvm.method.methods;

import me.matt.luka.interfaces.Stack;
import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;
/**
 * Implementation for the Luka instruction "Quit"
 * 
 * <ul>
 * <li>Classname: Quit.java
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
public class Quit extends LukaMethod {

	/**
	 * Checks preconditions to determine if interpreter should exit
	 * @param t A token which may be an instruction
	 * @param stack Reference to the Luka Virtual Machine's active stack
	 * @return true if conditions are met
	 */
    @Override
    public boolean canExecute(final Token t, final Stack<Token> stack) {
        return t.getSymbol().equalsIgnoreCase("quit");
    }

    /**
     * Ends the application
     * @param context Reference to MethodsContext
     */
    @Override
    public boolean execute(final MethodsContext context) {
        System.out.println("Bye!");
        System.exit(0);
        return true;
    }

}
