package me.matt.luka.lvm.method.methods;

import me.matt.luka.exception.LukaSyntaxException;
import me.matt.luka.interfaces.Stack;
import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

public class Define extends LukaMethod {

    @Override
    public boolean canExecute(Token t, Stack<Token> stack) {
        if (t.getSymbol().equals("def")) {
            if (stack.size() > 1) {
                if (stack.peek(1).isSymbol()) {
                    if (stack.peek().isNumber()) {
                        return true;
                    }
                    throw new LukaSyntaxException(
                            "The value should be a number");
                }
                throw new LukaSyntaxException("The variable should be a symbol");
            }
            throw new LukaSyntaxException(
                    "Stack of size 2 or more is required to define a variable");
        } else {
            return false;
        }
    }

    @Override
    public boolean execute(MethodsContext context) {
        Token number = context.getStack().pop();
        Token variable = context.getStack().pop();
        context.getDictionary().put(variable.getSymbol(), number);
        return true;
    }

}
