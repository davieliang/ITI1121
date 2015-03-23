package me.matt.luka.lvm.method;

import java.awt.Graphics;
import java.util.ArrayList;

import me.matt.luka.exception.LukaSyntaxException;
import me.matt.luka.lvm.method.methods.Add;
import me.matt.luka.lvm.method.methods.Clear;
import me.matt.luka.lvm.method.methods.Define;
import me.matt.luka.lvm.method.methods.Divide;
import me.matt.luka.lvm.method.methods.DrawArc;
import me.matt.luka.lvm.method.methods.DrawLine;
import me.matt.luka.lvm.method.methods.Move;
import me.matt.luka.lvm.method.methods.Multiply;
import me.matt.luka.lvm.method.methods.Pop;
import me.matt.luka.lvm.method.methods.Print;
import me.matt.luka.lvm.method.methods.Quit;
import me.matt.luka.lvm.method.methods.Set;
import me.matt.luka.lvm.method.methods.SetColour;
import me.matt.luka.lvm.method.methods.Subtract;
import me.matt.luka.lvm.method.methods.Undefine;
import me.matt.luka.wrappers.Token;

public class Methods {

    ArrayList<LukaMethod> methods;
    MethodsContext ctx = new MethodsContext();

    /**
     * Constructs an instance of the methods class, setting up all valid methods which may be executed during runtime
     */
    public Methods() {
        methods = new ArrayList<LukaMethod>();
        methods.add(new Add());
        methods.add(new Clear());
        methods.add(new Divide());
        methods.add(new DrawArc());
        methods.add(new DrawLine());
        methods.add(new Move());
        methods.add(new Multiply());
        methods.add(new Pop());
        methods.add(new Print());
        methods.add(new Quit());
        methods.add(new Subtract());
        methods.add(new Define());
        methods.add(new Set());
        methods.add(new Undefine());
        methods.add(new SetColour());
    }

    /**
     * Execute the functin of the token being read
     * 
     * @param token
     *            The token being read
     * @return True if the token execution was successful; otherwise false.
     */
    public boolean execute(final Token token) {
        String error = null;
        try {
            if (token.isNumber()) {
                ctx.getStack().push(token);
                return true;
            } else if (token.isSymbol()) {
                final String symbol = token.getSymbol();
                if (token.getSymbol().startsWith("/")) {
                    ctx.getStack().push(
                            new Token(token.getSymbol().substring(1)));
                    return true;
                } else {
                    for (final LukaMethod method : methods) {
                        if (method.canExecute(token, ctx.getStack())) {
                            return method.execute(ctx);
                        }
                    }
                    if (ctx.getDictionary().contains(symbol)) {
                        ctx.getStack().push(ctx.getDictionary().get(symbol));
                        return true;
                    }
                }
            }
        } catch (final LukaSyntaxException e) {
            /*
             * Execution will only get here when an error is caught
             */
            error = e.getMessage();
        }
        System.err.println("Luka Error Caught!");
        System.err.println(ctx.getDictionary().toString());
        System.err.println(ctx.getStack().toString());
        throw new LukaSyntaxException(error != null ? error : "Illegal token "
                + token.getSymbol());
    }

    /**
     * Initilizes the methods with the canvas to paint to
     * 
     * @param graphics
     *            The canvas the methods are able to paint to
     */
    public void init(final Graphics graphics) {
        ctx.init(graphics);
    }
}
