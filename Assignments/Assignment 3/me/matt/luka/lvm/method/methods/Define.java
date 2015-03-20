package me.matt.luka.lvm.method.methods;

import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

public class Define extends LukaMethod {

    @Override
    public boolean canExecute(Token t) {
        return t.getSymbol().equals("def");
    }

    @Override
    public boolean execute(MethodsContext context) {
        // TODO Auto-generated method stub
        return false;
    }

}
