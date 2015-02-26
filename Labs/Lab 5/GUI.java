import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class GUI extends Frame {

    public static void main(final String[] args) {
        new GUI();
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final Button bLeft = new Button("Left");

    private final Button bRight = new Button("Right");

    private final DisplayArea display = new DisplayArea();

    public GUI() {

        super("DGD - Week 8");

        this.setBackground(Color.WHITE);

        this.add(display, BorderLayout.CENTER);

        final Panel p = new Panel();

        p.add(bLeft);
        p.add(bRight);

        this.add(p, BorderLayout.SOUTH);

        bLeft.addActionListener(display);
        bRight.addActionListener(display);

        this.addWindowListener(new MyWindowAdapter());

        this.pack();
        this.setVisible(true);
    }
}