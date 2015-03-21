package me.matt.luka.lvm.method.methods;

import me.matt.luka.interfaces.Stack;
import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

public class Clear extends LukaMethod {

    @Override
    public boolean canExecute(Token t, Stack<Token> stack) {
        return t.getSymbol().equalsIgnoreCase("clear");
    }

    @Override
    public boolean execute(MethodsContext context) {
        while (!context.getStack().isEmpty()) {
            context.getStack().pop();
        }
        return true;
    }

}
