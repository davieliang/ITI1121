package me.matt.luka.lvm.method.methods;

import me.matt.luka.interfaces.Stack;
import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

public class Move extends LukaMethod {

    @Override
    public boolean canExecute(Token t, Stack<Token> stack) {
        return t.getSymbol().equalsIgnoreCase("moveto");
    }

    @Override
    public boolean execute(MethodsContext context) {
        Token y = context.getStack().pop();
        Token x = context.getStack().pop();
        context.getCursorPosiution().setLocation(x.getNumber(), y.getNumber());
        return true;
    }

}
