package me.matt.luka.lvm.method.methods;

import me.matt.luka.exception.LukaSyntaxException;
import me.matt.luka.interfaces.Stack;
import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

public class Move extends LukaMethod {

    @Override
    public boolean canExecute(final Token t, final Stack<Token> stack) {
        if (t.getSymbol().equalsIgnoreCase("moveto")) {
            if (stack.size() > 1) {
                if (stack.peek().isNumber() && stack.peek(1).isNumber()) {
                    return true;
                }
                throw new LukaSyntaxException(
                        "The last two elements in the stack must be numbers");
            }
            throw new LukaSyntaxException("Stack of size 2 or more is required");
        } else {
            return false;
        }
    }

    @Override
    public boolean execute(final MethodsContext context) {
        final Token y = context.getStack().pop();
        final Token x = context.getStack().pop();
        context.getCursorPosiution().setLocation(x.getNumber(), y.getNumber());
        return true;
    }

}
