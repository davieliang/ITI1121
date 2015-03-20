package me.matt.luka.lvm.method;

import java.awt.Graphics;
import java.awt.Point;

import me.matt.luka.interfaces.Stack;
import me.matt.luka.wrappers.Dictionary;
import me.matt.luka.wrappers.LinkedStack;
import me.matt.luka.wrappers.Token;

public class MethodsContext {

    private Graphics graphics;

    private Stack<Token> operands;

    private Point cursor;

    private Dictionary dictionary;

    public void init(Graphics graphics) {
        this.operands = new LinkedStack<Token>();
        this.graphics = graphics;
        this.cursor = new Point(0, 0);
        this.dictionary = new Dictionary();
    }

    public Stack<Token> getStack() {
        return operands;
    }

    public Point getCursorPosiution() {
        return cursor;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

}
