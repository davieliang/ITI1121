package me.matt.luka.lvm.method.methods;

import java.util.NoSuchElementException;

import me.matt.luka.exception.LukaSyntaxException;
import me.matt.luka.interfaces.Stack;
import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

public class Set extends LukaMethod {

    @Override
    public boolean canExecute(Token t, Stack<Token> stack) {
        return t.getSymbol().equalsIgnoreCase("set");
    }

    @Override
    public boolean execute(MethodsContext context) {
        Token value = context.getStack().pop();
        String key = context.getStack().pop().getSymbol();
        try {
            context.getDictionary().replace(key, value);
        } catch (NoSuchElementException e) {
            throw new LukaSyntaxException("Key not found: " + key);
        }
        return true;
    }

}
