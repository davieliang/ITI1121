package me.matt.jeopardy.gui.component;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class JeopardyButton extends JButton {

    /**
     *
     */
    private static final long serialVersionUID = -1099162168025108248L;
    private final int category;
    private final int question;

    public JeopardyButton(final ActionListener listener, final int category,
            final int question, final int amount) {
        super(String.valueOf(amount));
        this.category = category;
        this.question = question;
        this.addActionListener(listener);
    }

    public int getCategory() {
        return category;
    }

    public int getQuestion() {
        return question;
    }

}
