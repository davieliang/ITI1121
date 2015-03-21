package me.matt.luka.lvm.method;

import me.matt.luka.interfaces.Stack;
import me.matt.luka.wrappers.Token;

public abstract class LukaMethod {

    public abstract boolean canExecute(Token t, Stack<Token> s);

    public abstract boolean execute(MethodsContext context);

}
