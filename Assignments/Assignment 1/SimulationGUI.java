import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JProgressBar;

public class SimulationGUI extends JDialog {

    /**
     * 
     */
    private static final long serialVersionUID = -6208668398574414518L;

    private int target;
    private final JProgressBar bar = new JProgressBar();

    public SimulationGUI(int target) {
        this.target = target;
        create();
    }

    public void create() {
        if (target < 0) {
            bar.setIndeterminate(true);
        }
        bar.setStringPainted(true);
        setLocationRelativeTo(getOwner());
        setSize(200, 50);
        setResizable(false);
        setAlwaysOnTop(true);
        setTitle("Simulating...");
        add(bar, BorderLayout.CENTER);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }

    public void update(long current) {
        if (target > 0) {
            bar.setValue((int) (((double) current / (double) target) * 100));
        }
        bar.setString(target > 0 ? current + "/" + target + " generations"
                : "Current fitness: " + current);
    }
}
