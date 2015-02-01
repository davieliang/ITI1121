import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 6411499808530678723L;

    private JCheckBox[] check;
    private JPanel grid;
    private JTextArea info;
    private int dimension;

    public GUI(int dimension, boolean fitnessTest) {
        this.dimension = dimension;
        create(dimension, fitnessTest);
    }

    public GUI(int dimension) {
        this(dimension, false);
    }

    private void create(int dimension, boolean fitnessTest) {
        check = new JCheckBox[dimension * dimension];
        info = new JTextArea();
        grid = new JPanel();

        this.setLayout(new BorderLayout());
        grid.setLayout(new GridLayout(dimension, dimension));

        if (!fitnessTest) {
            for (int i = 0; i < check.length; i++) {
                check[i] = new JCheckBox();
                check[i].setEnabled(false);
                grid.add(check[i]);
            }
        } else {
            info.setText("Checking a box represents a queen. It will disable the row and column of that queen. Once all queens have been slected the fitness of the result will be genereated.");
            for (int i = 0; i < check.length; i++) {
                check[i] = new JCheckBox();
                grid.add(check[i]);
                check[i].addActionListener(e -> {
                    JCheckBox source = (JCheckBox) e.getSource();
                    int box = -1;
                    for (int j = 0; j < check.length; j++) {
                        if (check[j] == source) {
                            check[j].setEnabled(false);
                            box = j;
                            break;
                        }
                    }
                    if (box > -1) {
                        for (int j = 0; j < dimension; j++) {
                            check[box + j - (box % dimension)]
                                    .setEnabled(false);
                            check[box % dimension + (j * dimension)]
                                    .setEnabled(false);
                        }
                    }
                    boolean calculate = true;
                    for (JCheckBox c : check) {
                        if (c.isEnabled()) {
                            calculate = false;
                        }
                    }
                    if (calculate) {
                        int[] permiutation = new int[dimension];
                        for (int j = 0; j < check.length; j++) {
                            if (check[j].isSelected()) {
                                permiutation[j % dimension] = j / dimension;
                            }
                        }
                        Individual ind = new Individual(permiutation);
                        info.setText("fitness: " + ind.getFitness()
                                + System.lineSeparator() + "Attributes: "
                                + ind.toString());
                    }
                });

            }
        }

        info.setLineWrap(true);
        info.setWrapStyleWord(true);
        info.setColumns(grid.getWidth());
        info.setRows(5);
        info.setSize(info.getPreferredSize());

        info.setEditable(false);
        JScrollPane scroll = new JScrollPane(info,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(grid, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }

    public void update(String result, Individual fittest) {
        for (int i = 0; i < check.length; i++) {
            check[i].setSelected(false);
            if (i / dimension == fittest.getPositions()[i % dimension]) {
                check[i].setSelected(true);
            }
        }
        info.setText(result);

    }

}
