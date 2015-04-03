package us.mattandjoe.assignment4.part4;

import java.util.Iterator;
import java.util.List;

public class Frequency {
    public static void frequency(List<Tuple> l) {
        String result = "";
        Iterator<Tuple> i = l.iterator();
        while (i.hasNext()) {
            Tuple eval = i.next();
            if (!eval.visited()) {
                char current = eval.getChar();
                int count = 1;
                eval.toggle();
                Iterator<Tuple> j = l.iterator();

                while (j.hasNext()) {
                    Tuple next = j.next();
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
