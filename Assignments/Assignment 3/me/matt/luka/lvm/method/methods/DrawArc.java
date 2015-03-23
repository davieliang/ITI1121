package me.matt.luka.lvm.method.methods;

import me.matt.luka.exception.LukaSyntaxException;
import me.matt.luka.interfaces.Stack;
import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

public class DrawArc extends LukaMethod {

    @Override
    public boolean canExecute(final Token t, final Stack<Token> stack) {
        if (t.getSymbol().equalsIgnoreCase("arc")) {
            if (stack.size() > 2) {
                if (stack.peek().isNumber() && stack.peek(1).isNumber()
                        && stack.peek(2).isNumber()) {
                    return true;
                }
                throw new LukaSyntaxException(
                        "The last two elements in the stack must be numbers");
            }
            throw new LukaSyntaxException("Stack of size 3 or more is required");
        } else {
            return false;
        }
    }

    @Override
    public boolean execute(final MethodsContext context) {
        final Token a2 = context.getStack().pop();
        final Token a1 = context.getStack().pop();
        final Token r = context.getStack().pop();
        context.getGraphics().drawArc((int) context.getCursorPosition().getX(),
                (int) context.getCursorPosition().getY(), r.getNumber(),
                r.getNumber(), a1.getNumber(), a2.getNumber());
        return true;
    }

}
