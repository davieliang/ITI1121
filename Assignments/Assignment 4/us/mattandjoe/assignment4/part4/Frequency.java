package us.mattandjoe.assignment4.part4;

import java.util.Iterator;
import java.util.List;

/**
 * A class to calculate the frequency of a tuple
 *
 * <ul>
 * <li>22-03-2015
 * <li>Assignment 4
 * <li>Course: IT1 1121 A
 * <li>Langlois, Matt
 * <li>Student number: 7731813
 * <li>Faubert, Joel
 * <li>Student number: 2560106
 * </ul>
 *
 * @author Matt Langlois
 * @author Joel Faubert
 * @version 1
 *
 */
public class Frequency {

    public static void frequency(final List<Tuple> l) {
        if (l == null) {
            throw new NullPointerException("List cannot be null");
        }
        /*
         * A default result if the list is empty
         */
        String result = "Empty";
        if (l.size() > 0) {
            /*
             * Get the iterator of the tuple's list
             */
            final Iterator<Tuple> i = l.iterator();
            while (i.hasNext()) {
                final Tuple eval = i.next();
                /*
                 * Visit the next tuple
                 */
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
            result = result.substring(5, result.length() - 2);
        }
        System.out.println(result);
    }
}
