package me.matt.jeopardy;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import me.matt.jeopardy.gui.Jeopardy;

public class Application {

    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(() -> {
            try {
                new Jeopardy().setVisible(true);
            } catch (final Exception e) {
            }
        });

    }
}
