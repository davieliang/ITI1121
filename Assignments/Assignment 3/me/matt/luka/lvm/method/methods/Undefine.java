package me.matt.luka.lvm.method.methods;

import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

public class Undefine extends LukaMethod {

    @Override
    public boolean canExecute(Token t) {
        return t.getSymbol().equals("undef");
    }

    @Override
    public boolean execute(MethodsContext context) {
        Token variable = context.getStack().pop();
        context.getDictionary().remove(variable.getSymbol().substring(1));
        return true;
    }

}
