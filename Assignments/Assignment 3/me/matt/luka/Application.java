package me.matt.luka;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import me.matt.luka.gui.Viewer;
import me.matt.luka.util.StudentInfo;

/**
 * Runs the application by creating an Interpreter and a Viewer.
 * <ul>
 * <li>Classname: Application.java
 * <li>23-03-2015
 * <li>Assignment 3
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
