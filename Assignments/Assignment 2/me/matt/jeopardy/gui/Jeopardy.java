package me.matt.jeopardy.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import me.matt.jeopardy.gui.component.JeopardyButton;
import me.matt.jeopardy.util.Database;

/**
 * The main handles of the Jeopardy game. Allows the user to specify a database and then loads the questions from that database. It creates a grid of
 * questions below a label for the category. Requires at least one category and one question to be valid.
 *
 * Assignment: 2 Course: ITI1121 Section 1 Student no: 7731813
 *
 * @author Matt Langlois (Fletchto99@gmail.com)
 *
 */
public class Jeopardy extends JFrame {

    /**
     * A generated uID for serialization
     */
    private static final long serialVersionUID = -1395197212740446651L;

    public Jeopardy() throws IOException, URISyntaxException {
        this.initGui();
    }

    /**
     * Initializes the Graphical user interface
     */
    private void initGui() {
        final JPanel questions = new JPanel();
        /*
         * A button to load the database
         */
        final JButton load = new JButton("Load Game");
        /*
         * Allow the user to select a database file of file format .txt
         */
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                final JFileChooser chooser = new JFileChooser();
                chooser.setFileFilter(new FileNameExtensionFilter("TEXT FILES",
                        "txt"));
                chooser.removeChoosableFileFilter(chooser
                        .getAcceptAllFileFilter());
                final int choice = chooser.showOpenDialog(null);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    try {
                        questions.removeAll();
                        Jeopardy.this.populateQuestions(Database
                                .readQuestions(chooser.getSelectedFile()),
                                questions);
                    } catch (final Exception e) {
                        JOptionPane
                                .showMessageDialog(null,
                                        "Error Loading File. Please ensure the database is in the correct format.");
                    }
                }
            }
        });

        /*
         * Initialize the layout, add the components and set the GUI visible
         */
        this.setLayout(new BorderLayout());
        this.add(questions, BorderLayout.NORTH);
        this.add(load, BorderLayout.SOUTH);
        this.setTitle("Jeopardy Game");
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Populate the board's question buttons along with their point values.
     *
     * @param database
     *            The database instance
     * @param questions
     *            The panel on which to populate the question buttons
     */
    private void populateQuestions(final Database database,
            final JPanel questions) {
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
            questions.add(new JLabel(database.getCategory(i),
                    SwingConstants.CENTER));
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
         * Cause the layout manager to resize the GUI properly to contain all elements
         */
        this.pack();
    }
}
