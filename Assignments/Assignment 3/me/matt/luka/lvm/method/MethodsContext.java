package me.matt.luka.lvm.method;

import java.awt.Graphics;
import java.awt.Point;

import me.matt.luka.interfaces.Stack;
import me.matt.luka.wrappers.Dictionary;
import me.matt.luka.wrappers.LinkedStack;
import me.matt.luka.wrappers.Token;


/**
 * A class containing all of the accessors for the LukaMethods.
 * 
 * <ul>
 * <li>Classname: Application.java
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
 * @version 1
 *
 */
public class MethodsContext {

    private Graphics graphics;

    private Stack<Token> operands;

    private Point cursor;

    private Dictionary dictionary;

    /**
     * The location of the cursor on the screen
     * 
     * @return The location of the cursor on the screen
     */
    public Point getCursorPosition() {
        return cursor;
    }

    /**
     * The dictionary of variables
     * 
     * @return All of the valid variables the program has access to, ordered by insertion order
     */
    public Dictionary getDictionary() {
        return dictionary;
    }

    /**
     * The graphics instance
     * 
     * @return The instance of the graphics that the methods are able to paint to
     */
    public Graphics getGraphics() {
        return graphics;
    }

    /**
     * The stack containing all of the tokens
     * 
     * @return A stack of values the program has access to
     */
    public Stack<Token> getStack() {
        return operands;
    }

    /**
     * Initilizes the context for the currently running luka program
     * 
     * @param graphics
     *            The canvas to paint too
     */
    public void init(final Graphics graphics) {
        this.graphics = graphics;
        operands = new LinkedStack<Token>();
        cursor = new Point(0, 0);
        dictionary = new Dictionary();
    }

}
