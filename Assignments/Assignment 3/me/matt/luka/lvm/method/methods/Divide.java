package me.matt.luka.lvm.method.methods;

import java.util.Stack;

import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.wrappers.Token;

public class Divide extends LukaMethod {

    @Override
    public boolean Execute(Stack<Token> operands) {
        Token op1 = operands.pop();
        Token op2 = operands.pop();
        Token res = new Token(op2.getNumber() / op1.getNumber());
        operands.push(res);
        return false;
    }

    @Override
    public boolean canExecute(Token t, Stack<Token> oprands) {
        // TODO Auto-generated method stub
        return false;
    }

}
