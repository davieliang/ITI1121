package me.matt.luka.lvm.method;

import java.util.Stack;

import me.matt.luka.wrappers.Token;

public abstract class LukaMethod {
    
    public abstract boolean canExecute(Token t, Stack<Token> oprands);
    
    public abstract void Execute(Stack<Token> oprands);

}
