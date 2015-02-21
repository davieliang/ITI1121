package me.matt.jeopardy.gui.component;

import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * A button used in the Jeopardy game GUI. Contains some basic information to be used by the Jeopardy class.
 *
 * Assignment: 2
 * Course: ITI1121 Section 1
 * Student no: 7731813
 * 
 * @author Matt Langlois (Fletchto99@gmail.com)
 *
 */
public class JeopardyButton extends JButton {

    /**
     * An automatically generated ID
     */
    private static final long serialVersionUID = -1099162168025108248L;
    private final int category;
    private final int question;

    /**
     * Initializes a JeopardyButton
     *
     * @param listener
     *            A listener to perform an event when the button is pressed
     * @param category
     *            The category of the button
     * @param question
     *            The to be asked
     * @param amount
     *            The point value of this question
     */
    public JeopardyButton(final ActionListener listener, final int category,
            final int question, final int amount) {
        super(String.valueOf(amount));
        this.category = category;
        this.question = question;
        this.addActionListener(listener);
    }

    /**
     * Fetches the category of this button
     *
     * @return The button's category
     */
    public int getCategory() {
        return category;
    }

    /**
     * Fetches the question of this button
     *
     * @return The question this button contains
     */
    public int getQuestion() {
        return question;
    }

}
