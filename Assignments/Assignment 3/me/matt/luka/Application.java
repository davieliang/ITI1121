package me.matt.luka;

import me.matt.luka.gui.Viewer;
import me.matt.luka.uitl.StudentInfo;

/**
 * Runs the application.
 *
 * @author Marcel Turcotte
 */
public class Application {

    /**
     * Starts the application by creating an Interpreter and a Viewer.
     *
     * @param args unused.
     */
    public static void main(String[] args) {

        StudentInfo.display();

        new Viewer();
    }
}
