package me.matt.luka.lvm.method.methods;

import me.matt.luka.exception.LukaSyntaxException;
import me.matt.luka.interfaces.Stack;
import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

public class Add extends LukaMethod {

    @Override
    public boolean canExecute(Token t, Stack<Token> stack) {
        if (t.getSymbol().equalsIgnoreCase("add")) {
            if (stack.size() > 1) {
                if (stack.peek().isNumber() && stack.peek(1).isNumber()) {
                    return true;
                }
                throw new LukaSyntaxException(
                        "The tokens being added should both be numbers");
            }
            throw new LukaSyntaxException(
                    "Stack of size 2 or more is required to add elements");
        } else {
            return false;
        }
    }

    @Override
    public boolean execute(MethodsContext context) {
        Token op1 = context.getStack().pop();
        Token op2 = context.getStack().pop();
        Token res = new Token(op1.getNumber() + op2.getNumber());
        context.getStack().push(res);
        return true;
    }

}
