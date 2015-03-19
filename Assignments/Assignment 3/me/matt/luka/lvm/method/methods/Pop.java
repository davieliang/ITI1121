package me.matt.luka.lvm.method.methods;

import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

public class Pop extends LukaMethod {

    @Override
    public boolean canExecute(Token t) {
        return t.getSymbol().equalsIgnoreCase("pop");
    }

    @Override
    public boolean execute(MethodsContext context) {
        context.getStack().pop();
        return true;
    }

}
