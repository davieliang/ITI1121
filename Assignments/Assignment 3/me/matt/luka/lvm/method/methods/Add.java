package me.matt.luka.lvm.method.methods;

import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

public class Add extends LukaMethod {

    @Override
    public boolean canExecute(Token t) {
        return t.getSymbol().equalsIgnoreCase("add");
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
