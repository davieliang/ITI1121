package me.matt.luka.lvm.method.methods;

import java.awt.Color;
import java.lang.reflect.Field;

import me.matt.luka.exception.LukaSyntaxException;
import me.matt.luka.interfaces.Stack;
import me.matt.luka.lvm.method.LukaMethod;
import me.matt.luka.lvm.method.MethodsContext;
import me.matt.luka.wrappers.Token;

public class SetColour extends LukaMethod {

    @Override
    public boolean canExecute(final Token t, final Stack<Token> stack) {
        if (t.getSymbol().equalsIgnoreCase("setcolour")
                && !stack.peek().isSymbol()) {
            throw new LukaSyntaxException(
                    "Expected a symbol; recieved a number");
        }
        return t.getSymbol().equalsIgnoreCase("setcolour");
    }

    @Override
    public boolean execute(final MethodsContext context) {
        final String colour = context.getStack().pop().getSymbol();
        context.getGraphics().setColor(this.findColour(colour));
        return false;
    }

    private Color findColour(final String colour) {
        for (final Field f : Color.class.getFields()) {
            try {
                if (f.getType() == Color.class
                        && f.getName().equalsIgnoreCase(colour)) {
                    return (Color) f.get(null);
                }
            } catch (final IllegalAccessException e) {
                // Colour should always exist and be accessable
            }
        }
        throw new LukaSyntaxException("Colour " + colour + " not supported");
    }

}
