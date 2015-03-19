package me.matt.luka.lvm.method;

import me.matt.luka.interfaces.Stack;
import me.matt.luka.wrappers.Token;

public class Methods {

    /**
     * Instance variable. The operands stack.
     */
    protected Stack<Token> operands;

    public boolean execute(Token token) {
        if (token.isNumber()) {
            operands.push(token);
            return true;
        } else if (token.isSymbol()) {
            switch (token.getSymbol()) {
                case "div":
                    break;
                default:
                    return false;
            }
        }
        return false;
    }

}
