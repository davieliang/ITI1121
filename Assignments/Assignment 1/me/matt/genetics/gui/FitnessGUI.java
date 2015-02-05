package me.matt.genetics.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.DefaultCaret;

import me.matt.genetics.MessageType;
import me.matt.genetics.gui.components.StyledTextPane;
import me.matt.genetics.util.Configuration;
import me.matt.genetics.util.Util;
import me.matt.genetics.wrapper.Individual;
import me.matt.genetics.wrapper.Population;

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
    private StyledTextPane info;
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
        infinite = target < 0;
        this.createResult(simulation);
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
            this.log(System.lineSeparator() + "Attributes: " + ind.toString(),
                    MessageType.NORMAL);
        }
    }

    private void createResult(final boolean simulator) {
        check = new JCheckBox[dimension * dimension];
        info = new StyledTextPane();
        grid = new JPanel();

        bar.setStringPainted(true);

        grid.setLayout(new GridLayout(dimension, dimension));
        if (dimension <= Configuration.MAX_GUI_SIZE) {
            this.populateCheckboxes(simulator);
        }

        final DefaultCaret caret = (DefaultCaret) info.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        info.setEditable(false);
        info.append(
                (simulator ? "Populating the queens..."
                        : "Each checkbox represents a queen.")
                        + System.lineSeparator(), MessageType.INFO);

        list = new JList<String>(new String[] { "Simulating....." });
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        final JScrollPane gridScroll = new JScrollPane(grid);
        final JScrollPane infoScroll = new JScrollPane(info);
        final JScrollPane listScroll = new JScrollPane(list);
        if (gridScroll.getPreferredSize().width > 600
                || gridScroll.getPreferredSize().height > 600) {
            gridScroll.setPreferredSize(new Dimension(400, 400));
        }
        listScroll.setPreferredSize(new Dimension(100, 0));
        infoScroll.setPreferredSize(new Dimension(300, 100));
        if (dimension > Configuration.MAX_GUI_SIZE) {
            infoScroll.setPreferredSize(new Dimension(600, 400));
        }

        this.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        if (dimension <= Configuration.MAX_GUI_SIZE) {
            c.gridx = 0;
            c.gridy = 0;
            this.add(gridScroll, c);
        }
        if (simulator) {
            if (dimension <= Configuration.MAX_GUI_SIZE) {
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
                c.gridy = 0;
                this.add(infoScroll, c);
                c.gridx = 0;
                c.gridy = 1;
                this.add(bar, c);
                c.gridx = 1;
                c.gridy = 0;
                c.gridheight = 2;
                c.fill = GridBagConstraints.VERTICAL;
                c.anchor = GridBagConstraints.NORTH;
                this.add(listScroll, c);
                this.log(
                        "Dimension is too large to display grid. Only text will be shown, however you will see the attributes of the population at the end of the simulation.",
                        MessageType.ERROR);
            }
        } else {
            c.gridx = 0;
            c.gridy = 1;
            this.add(infoScroll, c);
            if (dimension > Configuration.MAX_GUI_SIZE) {
                info.setText("");
                info.append("Dimension is too big (> "
                        + Configuration.MAX_GUI_SIZE
                        + ")!!! The checker requires a dimension of "
                        + Configuration.MAX_GUI_SIZE + " or less.",
                        MessageType.ERROR);
            }
        }
        this.setTitle("N-Queen Solver - Genetic Algorithm");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public void finalize(final Population p, final String information) {
        bar.setValue(100);
        this.log("Removing Duplicates", MessageType.INFO);
        final Individual[] population = new Individual[p.getSize()];
        for (int i = 0; i < p.getSize(); i++) {
            population[i] = p.getIndividual(i);
        }
        final Individual[] individuals = Util.removeDuplicates(population);
        this.log((p.getSize() - individuals.length) + " duplicates removed",
                MessageType.WARNING);
        final String[] elements = new String[individuals.length];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = "Fitness: " + individuals[i].getFitness();
        }
        list.setListData(elements);
        list.setSelectedIndex(0);

        this.log("Printing Optimal Solution..." + System.lineSeparator(),
                MessageType.INFO);
        this.update(individuals[0], information, MessageType.SUCCESS);
        list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(final ListSelectionEvent arg0) {
                FitnessGUI.this.log(System.lineSeparator()
                        + "Selecting new individual... ", MessageType.INFO);
                FitnessGUI.this.update(
                        individuals[list.getSelectedIndex()],
                        System.lineSeparator()
                                + individuals[list.getSelectedIndex()]
                                        .toString(), MessageType.NORMAL);
            }

        });
    }

    public void log(final String s, final MessageType format) {
        info.append(s + System.lineSeparator(), format);
        System.out.println(s);
    }

    private void populateCheckboxes(final boolean simulation) {
        for (int i = 0; i < check.length; i++) {
            check[i] = new JCheckBox();
            check[i].setEnabled(!simulation);
            grid.add(check[i]);
            if (!simulation) {
                check[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        FitnessGUI.this.checkAction(e);
                    }
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
        if (dimension <= Configuration.MAX_GUI_SIZE) {
            for (int i = 0; i < check.length; i++) {
                check[i].setSelected(false);
                if (i / ind.getPositions().length == ind.getPositions()[i
                        % ind.getPositions().length]) {
                    check[i].setSelected(true);
                }
            }
        }
        if (!infinite && target > 0) {
            bar.setValue((int) (((double) evolutions / (double) target) * 100));
        } else if (infinite && target > 0) {
            bar.setValue(100 - (int) (((double) evolutions / (double) target) * 100));
        }
        bar.setString(!infinite ? evolutions + "/" + target + " generations"
                : "Current fitness: " + evolutions + " Start Fitness: "
                        + target);
    }

    public void update(final Individual ind, final String information,
            final MessageType type) {
        this.log(information, type);
        info.setCaretPosition(info.getDocument().getLength());
        if (dimension <= Configuration.MAX_GUI_SIZE) {
            for (int i = 0; i < check.length; i++) {
                check[i].setSelected(false);
                if (i / ind.getPositions().length == ind.getPositions()[i
                        % ind.getPositions().length]) {
                    check[i].setSelected(true);
                }
            }
        }
    }

}
