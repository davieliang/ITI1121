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
public class GUI extends JFrame {

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
    public GUI(final int dimension) {
        this(dimension, false);
    }

    /**
     * Creates and displays a GUI with the board dimensions specified
     *
     * @param dimension
     *            The dimension of the board
     * @param fitnessTest
     *            Determine how the checkboxes should be setup
     */
    public GUI(final int dimension, final boolean fitnessTest) {
        this.dimension = dimension;
        create(dimension, fitnessTest);
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

    private void create(final int dimension, final boolean fitnessTest) {
        check = new JCheckBox[dimension * dimension];
        info =
                new JTextArea("Checking a box represents a queen. "
                        + "It will disable the row and column of that queen. "
                        + "Once all queens have been slected the fitness "
                        + "of the result will be genereated.");
        grid = new JPanel();

        setLayout(new BorderLayout());
        grid.setLayout(new GridLayout(dimension, dimension));

        populateCheckboxes(fitnessTest);

        info.setLineWrap(true);
        info.setWrapStyleWord(true);
        info.setColumns(grid.getWidth());
        info.setRows(5);
        info.setSize(info.getPreferredSize());

        info.setEditable(false);
        final JScrollPane scroll =
                new JScrollPane(info,
                        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(grid, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    private void populateCheckboxes(final boolean fitnessTest) {
        for (int i = 0; i < check.length; i++) {
            check[i] = new JCheckBox();
            check[i].setEnabled(fitnessTest);
            grid.add(check[i]);
            check[i].addActionListener(e -> {
                checkAction(e);
            });
        }
    }

    /**
     * Update the board with the current status of the simulation
     *
     * @param information
     *            The string to display in the information pane
     * @param fittest
     *            The fittest individual to display in the simulation
     */
    public void update(final String information, final Individual fittest) {
        for (int i = 0; i < check.length; i++) {
            check[i].setSelected(false);
            if (i / dimension == fittest.getPositions()[i % dimension]) {
                check[i].setSelected(true);
            }
        }
        info.append(information + System.lineSeparator());

    }

}
