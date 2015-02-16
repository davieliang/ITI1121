package me.matt.jeopardy.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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

public class Jeopardy extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -1395197212740446651L;

    public Jeopardy() throws IOException, URISyntaxException {
        this.initGui();
    }

    private void initGui() {
        final JPanel questions = new JPanel();
        final JButton load = new JButton("Load Game");
        load.addActionListener(event -> {
            final JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new FileNameExtensionFilter("TEXT FILES",
                    "txt"));
            chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
            final int choice = chooser.showOpenDialog(null);
            if (choice == JFileChooser.APPROVE_OPTION) {
                try {
                    questions.removeAll();
                    this.populateQuestions(Database.readQuestions(chooser
                            .getSelectedFile().toPath()), questions);
                } catch (final Exception e) {
                    JOptionPane
                            .showMessageDialog(null,
                                    "Error Loading File. Please ensure the database is in the correct format.");
                }
            }
        });
        this.setLayout(new BorderLayout());
        this.add(questions, BorderLayout.NORTH);
        this.add(load, BorderLayout.SOUTH);
        this.setTitle("Jeopardy Game");
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void populateQuestions(final Database database,
            final JPanel questions) {
        final JeopardyButton[][] buttons = new JeopardyButton[database
                .getNumCategories()][database.getNumQuestions()];
        final ActionListener listener = e -> {
            final JeopardyButton source = ((JeopardyButton) e.getSource());

            if (source.getText().equalsIgnoreCase("-")) {
                return;
            }

            final String[] options = { "Reveal", "Cancel" };
            final int opt = JOptionPane.showOptionDialog(null, database
                    .getQuestion(source.getCategory(), source.getQuestion())
                    .getQuestion(), "Question", JOptionPane.YES_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (opt == 0) {
                JOptionPane.showMessageDialog(
                        null,
                        database.getQuestion(source.getCategory(),
                                source.getQuestion()).getResponse());
                source.setText("-");
            }
        };
        questions.setLayout(new GridLayout(database.getNumQuestions() + 1,
                database.getNumCategories()));
        for (int i = 0; i < database.getNumCategories(); i++) {
            questions.add(new JLabel(database.getCategory(i),
                    SwingConstants.CENTER));
        }
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JeopardyButton(listener, i, j,
                        (database.getNumQuestions() - j) * 100);
            }
        }
        for (int i = 0; i < buttons[0].length; i++) {
            for (final JeopardyButton[] button : buttons) {
                questions.add(button[i]);
            }
        }
        this.pack();
    }
}
