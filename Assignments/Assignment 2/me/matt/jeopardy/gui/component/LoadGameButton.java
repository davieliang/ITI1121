package me.matt.jeopardy.gui.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import me.matt.jeopardy.gui.Jeopardy;
import me.matt.jeopardy.util.Database;

/**
 * A button used to load the database of questions
 *
 * Assignment: 2 Course: ITI1121 Section 1 Student no: 7731813
 *
 * @author Matt Langlois (Fletchto99@gmail.com)
 *
 */
public class LoadGameButton extends JButton implements ActionListener {

    /**
     * An automatically generated ID
     */
    private static final long serialVersionUID = -1099162168025108248L;

    /**
     * An instance of the game
     */
    private final Jeopardy game;

    /**
     * Initializes a LoadGameButton
     *
     * @param game
     *            An instance of the current game
     */
    public LoadGameButton(final Jeopardy game) {
        super("Load Game");
        this.game = game;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(final ActionEvent event) {
        final JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("TEXT FILES", "txt"));
        chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
        final int choice = chooser.showOpenDialog(null);
        if (choice == JFileChooser.APPROVE_OPTION) {
            try {
                /*
                 * End any active games and begin the new one
                 */
                game.end();
                game.start(Database.readQuestions(chooser.getSelectedFile()));
            } catch (final Exception e) {
                JOptionPane
                        .showMessageDialog(null,
                                "Error Loading File. Please ensure the database is in the correct format.");
            }
        }
    }

}
