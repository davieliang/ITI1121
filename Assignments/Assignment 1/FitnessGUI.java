import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultCaret;

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
    private int target;
    private final boolean infinite;
    private JProgressBar bar = new JProgressBar();
    private JList<String> list;

    /**
     * Creates and displays a GUI with the board dimensions specified
     *
     * @param dimension
     *            The dimension of the board
     */
    public FitnessGUI(final int dimension, final boolean simulation,
            final int target) {
        this.dimension = dimension;
        this.target = target;
        this.infinite = target < 0;
        createResult(simulation);
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

    private void createResult(boolean simulator) {
        check = new JCheckBox[dimension * dimension];
        info =
                new JTextArea((simulator ? "Populating the queens..."
                        : "Each checkbox represents a queen.")
                        + System.lineSeparator());
        grid = new JPanel();

        bar.setStringPainted(true);

        grid.setLayout(new GridLayout(dimension, dimension));
        populateCheckboxes(simulator);

        DefaultCaret caret = (DefaultCaret) info.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        info.setLineWrap(true);
        info.setWrapStyleWord(true);
        info.setColumns(grid.getWidth());
        info.setRows(5);
        info.setEditable(false);

        list = new JList<>(new String[] { "Simulating....." });
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        final JScrollPane gridScroll = new JScrollPane(grid);
        final JScrollPane infoScroll = new JScrollPane(info);
        final JScrollPane listScroll = new JScrollPane(list);
        if (gridScroll.getPreferredSize().width > 600
                || gridScroll.getPreferredSize().height > 600) {
            gridScroll.setPreferredSize(new Dimension(400, 400));
        }
        listScroll.setPreferredSize(new Dimension(100, 0));

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(gridScroll, c);
        if (simulator) {
            c.gridx = 0;
            c.gridy = 1;
            this.add(bar, c);
            c.gridx = 0;
            c.gridy = 2;
            this.add(infoScroll, c);
            c.gridx = 1;
            c.gridy = 0;
            c.gridheight = 3;
            c.weightx = 100;
            c.fill = GridBagConstraints.VERTICAL;
            c.anchor = GridBagConstraints.NORTH;
            this.add(listScroll, c);
        } else {
            c.gridx = 0;
            c.gridy = 1;
            this.add(infoScroll, c);
        }
        setTitle("N-Queen Solver - Genetic Algorithm");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void populateCheckboxes(boolean simulation) {
        for (int i = 0; i < check.length; i++) {
            check[i] = new JCheckBox();
            check[i].setEnabled(!simulation);
            grid.add(check[i]);
            if (!simulation) {
                check[i].addActionListener(e -> {
                    checkAction(e);
                });
            }
        }
    }

    public void update(Individual ind, long evolutions) {
        for (int i = 0; i < check.length; i++) {
            check[i].setSelected(false);
            if (i / ind.getPositions().length == ind.getPositions()[i
                    % ind.getPositions().length]) {
                check[i].setSelected(true);
            }
            if (!infinite && target > 0) {
                bar.setValue((int) (((double) evolutions / (double) target) * 100));
            } else if (infinite && target > 0) {
                bar.setValue(100 - (int) (((double) evolutions / (double) target) * 100));
            }
            bar.setString(!infinite ? evolutions + "/" + target
                    + " generations" : "Current fitness: " + evolutions
                    + " Start Fitness: " + target);
        }
    }

    public void update(Individual ind, String information) {
        log(information);
        info.setCaretPosition(info.getDocument().getLength());
        for (int i = 0; i < check.length; i++) {
            check[i].setSelected(false);
            if (i / ind.getPositions().length == ind.getPositions()[i
                    % ind.getPositions().length]) {
                check[i].setSelected(true);
            }
        }
    }

    private void log(String s) {
        info.append(s + System.lineSeparator());
        System.out.println(s);
    }

    public void finalize(Population p, String information) {
        update(p.getFittest(), information);
        log("Removing Duplicates");
        Individual[] individuals = Util.removeDuplicates(p.getIndividuals());
        log((p.getIndividuals().length - individuals.length)
                + " duplicates removed");
        String[] elements = new String[individuals.length];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = "Fitness: " + individuals[i].getFitness();
        }
        list.setListData(elements);
        list.setSelectedIndex(0);
        list.addListSelectionListener(e -> {
            update(individuals[list.getSelectedIndex()], System.lineSeparator()
                    + "Selecting new individual... " + System.lineSeparator()
                    + individuals[list.getSelectedIndex()].toString());
        });
    }

    public void setTarget(int target) {
        if (this.target < 0) {
            this.target = target;
        }
    }

}
