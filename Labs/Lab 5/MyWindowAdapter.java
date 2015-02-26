import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MyWindowAdapter extends WindowAdapter {

    @Override
    public void windowClosing(final WindowEvent e) {
        System.exit(0);
    }

}