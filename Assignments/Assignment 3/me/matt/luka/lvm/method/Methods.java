package me.matt.luka.lvm.method;

import java.awt.Graphics;
import java.util.ArrayList;

import me.matt.luka.lvm.method.methods.Add;
import me.matt.luka.lvm.method.methods.Clear;
import me.matt.luka.lvm.method.methods.Divide;
import me.matt.luka.lvm.method.methods.DrawArc;
import me.matt.luka.lvm.method.methods.DrawLine;
import me.matt.luka.lvm.method.methods.Move;
import me.matt.luka.lvm.method.methods.Multiply;
import me.matt.luka.lvm.method.methods.Pop;
import me.matt.luka.lvm.method.methods.Print;
import me.matt.luka.lvm.method.methods.Quit;
import me.matt.luka.lvm.method.methods.Subtract;
import me.matt.luka.wrappers.Token;

public class Methods {

    ArrayList<LukaMethod> methods;
    MethodsContext ctx = new MethodsContext();

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
    }

    public void init(Graphics graphics) {
        ctx.init(graphics);
    }

    public boolean execute(Token token) {
        if (token.isNumber()) {
            ctx.getStack().push(token);
            return true;
        } else if (token.isSymbol()) {
            for (LukaMethod method : methods) {
                if (method.canExecute(token)) {
                    return method.execute(ctx);
                }
            }
        }
        return false;
    }

}
