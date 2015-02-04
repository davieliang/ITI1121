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
    private final JProgressBar bar = new JProgressBar();
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
        this.createResult(simulation);
    }

    private void checkAction(final ActionEvent e) {
        final JCheckBox source = (JCheckBox) e.getSource();
        int box = -1;

        // Determine the location of the checkbox in the array
        for (int j = 0; j < this.check.length; j++) {
            if (this.check[j] == source) {
                this.check[j].setEnabled(false);
                box = j;
                break;
            }
        }

        // Determine which rows and columns should be eliminated
        if (box > -1) {
            for (int j = 0; j < this.dimension; j++) {
                this.check[box + j - (box % this.dimension)].setEnabled(false);
                this.check[box % this.dimension + (j * this.dimension)]
                        .setEnabled(false);
            }
        }

        // Check if every checkbox has been disabled
        boolean calculate = true;
        for (final JCheckBox c : this.check) {
            if (c.isEnabled()) {
                calculate = false;
            }
        }

        // If the board is ready, calculate the fitness
        if (calculate) {
            final int[] permiutation = new int[this.dimension];
            for (int j = 0; j < this.check.length; j++) {
                if (this.check[j].isSelected()) {
                    permiutation[j % this.dimension] = j / this.dimension;
                }
            }
            final Individual ind = new Individual(permiutation);
            this.info.setText("fitness: " + ind.getFitness()
                    + System.lineSeparator() + "Attributes: " + ind.toString());
        }
    }

    private void createResult(final boolean simulator) {
        this.check = new JCheckBox[this.dimension * this.dimension];
        this.info = new JTextArea((simulator ? "Populating the queens..."
                : "Each checkbox represents a queen.") + System.lineSeparator());
        this.grid = new JPanel();

        this.bar.setStringPainted(true);

        this.grid.setLayout(new GridLayout(this.dimension, this.dimension));
        this.populateCheckboxes(simulator);

        final DefaultCaret caret = (DefaultCaret) this.info.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        this.info.setLineWrap(true);
        this.info.setWrapStyleWord(true);
        this.info.setColumns(this.grid.getWidth());
        this.info.setRows(5);
        this.info.setEditable(false);

        this.list = new JList<>(new String[] { "Simulating....." });
        this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        final JScrollPane gridScroll = new JScrollPane(this.grid);
        final JScrollPane infoScroll = new JScrollPane(this.info);
        final JScrollPane listScroll = new JScrollPane(this.list);
        if (gridScroll.getPreferredSize().width > 600
                || gridScroll.getPreferredSize().height > 600) {
            gridScroll.setPreferredSize(new Dimension(400, 400));
        }
        listScroll.setPreferredSize(new Dimension(100, 0));

        this.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(gridScroll, c);
        if (simulator) {
            c.gridx = 0;
            c.gridy = 1;
            this.add(this.bar, c);
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
        this.setTitle("N-Queen Solver - Genetic Algorithm");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public void finalize(final Population p, final String information) {
        this.update(p.getFittest(), information);
        this.log("Removing Duplicates");
        final Individual[] individuals = Util.removeDuplicates(p
                .getIndividuals());
        this.log((p.getIndividuals().length - individuals.length)
                + " duplicates removed");
        final String[] elements = new String[individuals.length];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = "Fitness: " + individuals[i].getFitness();
        }
        this.list.setListData(elements);
        this.list.setSelectedIndex(0);
        this.list.addListSelectionListener(e -> {
            this.update(
                    individuals[this.list.getSelectedIndex()],
                    System.lineSeparator()
                            + "Selecting new individual... "
                            + System.lineSeparator()
                            + individuals[this.list.getSelectedIndex()]
                                    .toString());
        });
    }

    private void log(final String s) {
        this.info.append(s + System.lineSeparator());
        System.out.println(s);
    }

    private void populateCheckboxes(final boolean simulation) {
        for (int i = 0; i < this.check.length; i++) {
            this.check[i] = new JCheckBox();
            this.check[i].setEnabled(!simulation);
            this.grid.add(this.check[i]);
            if (!simulation) {
                this.check[i].addActionListener(e -> {
                    this.checkAction(e);
                });
            }
        }
    }

    public void setTarget(final int target) {
        if (this.target < 0) {
            this.target = target;
        }
    }

    public void update(final Individual ind, final long evolutions) {
        for (int i = 0; i < this.check.length; i++) {
            this.check[i].setSelected(false);
            if (i / ind.getPositions().length == ind.getPositions()[i
                    % ind.getPositions().length]) {
                this.check[i].setSelected(true);
            }
            if (!this.infinite && this.target > 0) {
                this.bar.setValue((int) (((double) evolutions / (double) this.target) * 100));
            } else if (this.infinite && this.target > 0) {
                this.bar.setValue(100 - (int) (((double) evolutions / (double) this.target) * 100));
            }
            this.bar.setString(!this.infinite ? evolutions + "/" + this.target
                    + " generations" : "Current fitness: " + evolutions
                    + " Start Fitness: " + this.target);
        }
    }

    public void update(final Individual ind, final String information) {
        this.log(information);
        this.info.setCaretPosition(this.info.getDocument().getLength());
        for (int i = 0; i < this.check.length; i++) {
            this.check[i].setSelected(false);
            if (i / ind.getPositions().length == ind.getPositions()[i
                    % ind.getPositions().length]) {
                this.check[i].setSelected(true);
            }
        }
    }

}
