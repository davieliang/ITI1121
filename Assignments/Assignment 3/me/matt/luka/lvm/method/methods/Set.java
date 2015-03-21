package me.matt.luka.lvm.method.methods;

import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

public class Set extends LukaMethod {

    @Override
    public boolean canExecute(Token t) {
        return t.getSymbol().equalsIgnoreCase("set");
    }

    @Override
    public boolean execute(MethodsContext context) {
        Token value = context.getStack().pop();
        String key = context.getStack().pop().getSymbol().substring(1);
        context.getDictionary().replace(key, value);
        return true;
    }

}
