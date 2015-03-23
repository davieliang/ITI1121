package me.matt.luka;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import me.matt.luka.gui.Viewer;
import me.matt.luka.util.StudentInfo;

/**
 * Runs the application.
 *
 * @author Marcel Turcotte
 */
public class Application {

    /**
     * Starts the application by creating an Interpreter and a Viewer.
     *
     * @param args
     *            unused.
     * @throws UnsupportedLookAndFeelException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        StudentInfo.display();

        new Viewer();
    }
}
