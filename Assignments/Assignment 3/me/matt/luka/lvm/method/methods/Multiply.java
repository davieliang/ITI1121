package me.matt.luka.lvm.method.methods;

import me.matt.luka.interfaces.Stack;
import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

public class Multiply extends LukaMethod {

    @Override
    public boolean canExecute(Token t, Stack<Token> stack) {
        return t.getSymbol().contains("mul");
    }

    @Override
    public boolean execute(MethodsContext context) {
        Token op1 = context.getStack().pop();
        Token op2 = context.getStack().pop();
        Token res = new Token(op1.getNumber() * op2.getNumber());
        context.getStack().push(res);
        return true;
    }

}
