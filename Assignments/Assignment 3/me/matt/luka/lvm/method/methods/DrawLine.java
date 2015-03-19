package me.matt.luka.lvm.method.methods;

import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

public class DrawLine extends LukaMethod {

    @Override
    public boolean canExecute(Token t) {
        return t.getSymbol().equalsIgnoreCase("lineto");
    }

    @Override
    public boolean execute(MethodsContext context) {
        Token y = context.getStack().pop();
        Token x = context.getStack().pop();
        context.getGraphics().drawLine(
                (int) context.getCursorPosiution().getX(),
                (int) context.getCursorPosiution().getY(), x.getNumber(),
                y.getNumber());
        context.getCursorPosiution().setLocation(x.getNumber(), y.getNumber());
        return true;
    }

}
