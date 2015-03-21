package me.matt.luka.lvm.method.methods;

import java.util.NoSuchElementException;

import me.matt.luka.exception.LukaSyntaxException;
import me.matt.luka.interfaces.Stack;
import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

public class Undefine extends LukaMethod {

    @Override
    public boolean canExecute(Token t, Stack<Token> stack) {
        return t.getSymbol().equals("undef");
    }

    @Override
    public boolean execute(MethodsContext context) {
        String variable = context.getStack().pop().getSymbol();
        try {
            context.getDictionary().remove(variable);
        } catch (NoSuchElementException e) {
            throw new LukaSyntaxException("Key not found: " + variable);
        }
        return true;
    }

}
