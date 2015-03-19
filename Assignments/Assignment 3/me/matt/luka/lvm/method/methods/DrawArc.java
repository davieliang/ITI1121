package me.matt.luka.lvm.method.methods;

import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

public class DrawArc extends LukaMethod {

    @Override
    public boolean canExecute(Token t) {
        return t.getSymbol().equalsIgnoreCase("arc");
    }

    @Override
    public boolean execute(MethodsContext context) {
        Token a2 = context.getStack().pop();
        Token a1 = context.getStack().pop();
        Token r = context.getStack().pop();
        context.getGraphics().drawArc(
                (int) context.getCursorPosiution().getX(),
                (int) context.getCursorPosiution().getY(), r.getNumber(),
                r.getNumber(), a1.getNumber(), a2.getNumber());
        return true;
    }

}
