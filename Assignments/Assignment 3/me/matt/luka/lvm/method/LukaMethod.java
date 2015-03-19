package me.matt.luka.lvm.method;

import me.matt.luka.wrappers.Token;

public abstract class LukaMethod {

    public abstract boolean canExecute(Token t);

    public abstract boolean execute(MethodsContext context);

}
