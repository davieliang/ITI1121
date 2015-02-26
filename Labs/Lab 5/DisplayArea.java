import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayArea extends Canvas implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = -3412012584625521953L;
    private final Point center;

    DisplayArea() {
        this.setSize(200, 200);
        center = new Point(100, 100);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {

        final String cmd = e.getActionCommand();

        if (cmd.equals("Left")) {
            center.x = (center.x + 190) % 200; // subtracts 10
        } else if (cmd.equals("Right")) {
            center.x = (center.x + 10) % 200;
        }

        this.repaint();
    }

    @Override
    public void paint(final Graphics g) {

        g.setColor(Color.RED);
        g.fillOval(center.x - 5, center.y - 5, 10, 10);

    }
}