import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * Creates a GUI for the N-Queens solver solution.
 *
 * @author mattlanglois
 *
 */
public class FitnessGUI extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 6411499808530678723L;

    private JCheckBox[] check;
    private JPanel grid;
    private JTextArea info;
    private final int dimension;

    /**
     * Creates and displays a GUI with the board dimensions specified
     *
     * @param dimension
     *            The dimension of the board
     */
    public FitnessGUI(final int dimension) {
        this.dimension = dimension;
        createResult();
    }

    /**
     * Creates and displays a GUI with the board dimensions specified
     *
     * @param dimension
     *            The dimension of the board
     * @param fitnessTest
     *            Determine how the checkboxes should be setup
     */
    public FitnessGUI(final Individual fittest, final String result) {
        this.dimension = fittest.getPositions().length;
        createResult(fittest, result);
    }

    private void checkAction(final ActionEvent e) {
        final JCheckBox source = (JCheckBox) e.getSource();
        int box = -1;

        // Determine the location of the checkbox in the array
        for (int j = 0; j < check.length; j++) {
            if (check[j] == source) {
                check[j].setEnabled(false);
                box = j;
                break;
            }
        }

        // Determine which rows and columns should be eliminated
        if (box > -1) {
            for (int j = 0; j < dimension; j++) {
                check[box + j - (box % dimension)].setEnabled(false);
                check[box % dimension + (j * dimension)].setEnabled(false);
            }
        }

        // Check if every checkbox has been disabled
        boolean calculate = true;
        for (final JCheckBox c : check) {
            if (c.isEnabled()) {
                calculate = false;
            }
        }

        // If the board is ready, calculate the fitness
        if (calculate) {
            final int[] permiutation = new int[dimension];
            for (int j = 0; j < check.length; j++) {
                if (check[j].isSelected()) {
                    permiutation[j % dimension] = j / dimension;
                }
            }
            final Individual ind = new Individual(permiutation);
            info.setText("fitness: " + ind.getFitness()
                    + System.lineSeparator() + "Attributes: " + ind.toString());
        }
    }

    private void createResult() {
        createResult(null, "Check the checkboxes you wish to represent queens.");
    }

    private void createResult(final Individual fittest, final String result) {
        check = new JCheckBox[dimension * dimension];
        info = new JTextArea(result);
        grid = new JPanel();

        setLayout(new BorderLayout());
        grid.setLayout(new GridLayout(dimension, dimension));
        populateCheckboxes(fittest);

        info.setLineWrap(true);
        info.setWrapStyleWord(true);
        info.setColumns(grid.getWidth());
        info.setRows(5);
        info.setSize(info.getPreferredSize());

        info.setEditable(false);
        final JScrollPane scroll = new JScrollPane(info,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(grid, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    private void populateCheckboxes(final Individual fittest) {
        for (int i = 0; i < check.length; i++) {
            check[i] = new JCheckBox();
            check[i].setEnabled(fittest == null);
            grid.add(check[i]);
            if (fittest != null) {
                if (i / fittest.getPositions().length == fittest.getPositions()[i
                        % fittest.getPositions().length]) {
                    check[i].setSelected(true);
                }
            } else {
                check[i].addActionListener(e -> {
                    checkAction(e);
                });
            }
        }
    }

}
