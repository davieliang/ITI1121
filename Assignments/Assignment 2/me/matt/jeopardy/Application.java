package me.matt.jeopardy;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import me.matt.jeopardy.gui.Jeopardy;
import me.matt.jeopardy.util.StudentInfo;

/**
 * This class acts as an entry point for the application. The GUI is initialized and displayed.
 *
 * Assignment: 2
 * Course: ITI1121
 * Section: 1
 * Student no: 7731813
 *
 * @author Matt Langlois (Fletchto99@gmail.com)
 *
 */
public class Application {

    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        StudentInfo.display(); // Display student information
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Make GUI look nice on windows
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Jeopardy();
                } catch (final Exception e) {
                    System.out.println("Error initilizing application.");
                }
            }
        });

    }
}
