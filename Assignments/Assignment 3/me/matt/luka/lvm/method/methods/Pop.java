package me.matt.luka.lvm.method.methods;

import me.matt.luka.exception.LukaSyntaxException;
import me.matt.luka.interfaces.Stack;
import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

public class Pop extends LukaMethod {

    @Override
    public boolean canExecute(final Token t, final Stack<Token> stack) {
        if (t.getSymbol().equalsIgnoreCase("pop")) {
            if (!stack.isEmpty()) {
                return true;
            }
            throw new LukaSyntaxException("Stack cannot be empty");
        } else {
            return false;
        }
    }

    @Override
    public boolean execute(final MethodsContext context) {
        context.getStack().pop();
        return true;
    }

}
