package me.matt.jeopardy.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import me.matt.jeopardy.gui.component.EndGameButton;
import me.matt.jeopardy.gui.component.JeopardyButton;
import me.matt.jeopardy.gui.component.JeopardyCategory;
import me.matt.jeopardy.gui.component.LoadGameButton;
import me.matt.jeopardy.util.Database;

/**
 * The main handles of the Jeopardy game. Allows the user to specify a database and then loads the questions from that database. It creates a grid of
 * questions below a label for the category. Requires at least one category and one question to be valid.
 *
 * Assignment: 2
 * Course: ITI1121
 * Section: 1
 * Student no: 7731813
 *
 * @author Matt Langlois (Fletchto99@gmail.com)
 *
 */
public class Jeopardy extends JFrame {

    /**
     * A generated uID for serialization
     */
    private static final long serialVersionUID = -1395197212740446651L;
    private final JPanel questions;
    private final LoadGameButton load;
    private final EndGameButton end;
    private boolean active = false;

    /**
     * Creates an instance of the jeopardy game. See Application as the entry point for this game
     */
    public Jeopardy() {

        /*
         * Initilize variables
         */
        questions = new JPanel();
        load = new LoadGameButton(this);
        end = new EndGameButton(this);

        /*
         * Initialize the layout, add load game button
         */
        this.setLayout(new BorderLayout());
        this.add(load, BorderLayout.SOUTH);

        /*
         * Setup some settings and titles
         */
        this.setTitle("Jeopardy Game");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
         * Let the layout manager resize to fit
         */
        this.pack();

        /*
         * Set the GUI visible
         */
        this.setVisible(true);
    }

    /**
     * Ends the currently active game of Jeopardy
     */
    public void end() {
        /*
         * Remove all old questions
         */
        questions.removeAll();

        /*
         * Cleanup GUI
         */
        this.remove(end);
        this.remove(questions);
        this.add(load, BorderLayout.SOUTH);

        /*
         * Allow the layout manager to resize the GUI
         */
        this.pack();
        active = false;
    }

    /**
     * Populate the board's question buttons along with their point values.
     *
     * @param database
     *            The database of questions to base this game off of
     */
    public void start(final Database database) {

        /*
         * End active game if one exists
         */
        if (active) {
            this.end();
        }

        /*
         * Creates an empty array of jeopardy buttons
         */
        final JeopardyButton[][] buttons = new JeopardyButton[database
                .getNumCategories()][database.getNumQuestions()];

        /*
         * Use a grid layout manager to manage the buttons
         */
        questions.setLayout(new GridLayout(database.getNumQuestions() + 1,
                database.getNumCategories()));

        /*
         * Add the category labels to the panel
         */
        for (int i = 0; i < database.getNumCategories(); i++) {
            questions.add(new JeopardyCategory(database.getCategory(i)));
        }

        /*
         * Populate the questions
         */
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JeopardyButton(database, i, j);
            }
        }
        /*
         * Add the button to the panel
         */
        for (int i = 0; i < buttons[0].length; i++) {
            for (final JeopardyButton[] button : buttons) {
                questions.add(button[i]);
            }
        }

        /*
         * Setup buttons
         */
        this.remove(load);
        this.add(questions, BorderLayout.NORTH);
        this.add(end, BorderLayout.SOUTH);

        /*
         * Cause the layout manager to resize the GUI properly to contain all elements
         */
        this.pack();
        active = true;
    }
}
