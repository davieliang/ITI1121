package me.matt.genetics.gui.components;
import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import me.matt.genetics.MessageType;

/**
 * Creates a text pane that can hold color.
 *
 * @author matthewlanglois
 *
 */
public class StyledTextPane extends JTextPane {

    private static final long serialVersionUID = -5171292233885873672L;

    /**
     * Adds a message to the document.
     *
     * @param message
     *            The message to append.
     */
    public void append(final String message, final MessageType style) {
        final Document doc = this.getDocument();
        final SimpleAttributeSet aset = new SimpleAttributeSet();
        switch (style) {
            case ERROR:
                System.out.println("Applying bold");
                aset.addAttribute(StyleConstants.Bold, true);
                aset.addAttribute(StyleConstants.Foreground, Color.RED);
                break;
            case INFO:
                aset.addAttribute(StyleConstants.Italic, true);
                aset.addAttribute(StyleConstants.Foreground, Color.BLUE);
                break;
            case SUCCESS:
                aset.addAttribute(StyleConstants.Foreground,
                        Color.GREEN.darker());
                break;
            case WARNING:
                aset.addAttribute(StyleConstants.Foreground,
                        Color.YELLOW.darker());
                break;
            default:
                break;
        }
        try {
            doc.insertString(doc.getLength(), message, aset);
        } catch (final BadLocationException e) {
            e.printStackTrace();
        }
    }
}
