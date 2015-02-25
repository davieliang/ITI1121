package me.matt.jeopardy.gui.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import me.matt.jeopardy.gui.Jeopardy;

/**
 * A button used to end the current game of jeopardy
 *
 * Assignment: 2 Course: ITI1121 Section 1 Student no: 7731813
 *
 * @author Matt Langlois (Fletchto99@gmail.com)
 *
 */
public class EndGameButton extends JButton implements ActionListener {

    /**
     * An automatically generated ID
     */
    private static final long serialVersionUID = -1099162168025108248L;

    /**
     * An instance of the game
     */
    private final Jeopardy game;

    /**
     * Initializes a JeopardyButton
     *
     * @param game
     *            An instance of the current game
     */
    public EndGameButton(final Jeopardy game) {
        super("End Game");
        this.game = game;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(final ActionEvent event) {
        final int opt = JOptionPane.showConfirmDialog(game,
                "Are you sure you wish to end the game?");
        if (opt == JOptionPane.YES_OPTION) {
            /*
             * End the game and notify the user
             */
            game.end();
            JOptionPane.showMessageDialog(game, "Thanks for playing!");
        }
    }

}
