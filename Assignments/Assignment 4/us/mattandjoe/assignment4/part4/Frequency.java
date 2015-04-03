package us.mattandjoe.assignment4.part4;

import java.util.Iterator;
import java.util.List;

public class Frequency {
    public static void frequency(final List<Tuple> l) {
        String result = "";
        final Iterator<Tuple> i = l.iterator();
        while (i.hasNext()) {
            final Tuple eval = i.next();
            if (!eval.visited()) {
                final char current = eval.getChar();
                int count = 1;
                eval.toggle();
                final Iterator<Tuple> j = l.iterator();

                while (j.hasNext()) {
                    final Tuple next = j.next();
                    if (!next.visited()) {
                        if (next.getChar() == current) {
                            count++;
                            next.toggle();
                        }
                    }
                }
                result += current + " : " + count + ", ";
            }
        }
        System.out.println(result.substring(0, result.length() - 2));
    }
}
