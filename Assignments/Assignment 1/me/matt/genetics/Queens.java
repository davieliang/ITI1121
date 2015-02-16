package me.matt.genetics;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import me.matt.genetics.concurrent.Simulation;
import me.matt.genetics.gui.FitnessGUI;
import me.matt.genetics.util.StudentInfo;

/**
 * The class <b>Queens</b> implements the top-level of the genetic algorithm. It has a main method that reads parameters from the command line or
 * using input dialogs. Here is a sample run.
 *
 * <pre>
 * java Queens 500 100 8
 * Generations=65, Individual: {fitness=0, attributes=[5,3,0,4,7,1,6,2]}
 * </pre>
 *
 * Because of the ``probabilistic'' nature of the algorithm, each run is likely to produce a new solution.
 *
 * @author Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */

public class Queens {

    private static void execute(final String[] args) {
        int generations = -1, size = 100, dimension = 8;
        String s = "Text";
        final String[] options = { "GUI", "Text", "Checker" };
        if (args.length == 4) {
            generations = Integer.parseInt(args[0]);
            size = Integer.parseInt(args[1]);
            dimension = Integer.parseInt(args[2]);
            s = args[3];
        } else {
            s = (String) JOptionPane.showInputDialog(null, "",
                    "Method Selection", JOptionPane.PLAIN_MESSAGE, null,
                    options, s);
        }

        if (s == null) {
            System.exit(0);
        }
        if (s.equalsIgnoreCase(options[0]) || s.equalsIgnoreCase(options[1])) {
            if (args.length != 4) {
                try {
                    generations = Integer.parseInt(JOptionPane.showInputDialog(
                            "Input the number of generations. -1 for infinite",
                            String.valueOf(generations)));
                    size = Integer.parseInt(JOptionPane.showInputDialog(
                            "Input the size of the population (>1)",
                            String.valueOf(size)));
                    dimension = Integer.parseInt(JOptionPane.showInputDialog(
                            "Input the dimension of the board (>3)",
                            String.valueOf(dimension)));
                } catch (final Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Invalid input entered. Please try again.");
                    System.exit(0);
                }
            }
            if (s.equalsIgnoreCase(options[0])) {
                Queens.simulate(generations, size, dimension, true);
            } else {
                Queens.simulate(generations, size, dimension, false);
            }
        } else {
            dimension = Integer.parseInt(JOptionPane.showInputDialog(
                    "Input the dimension of the board", "8"));
            new FitnessGUI(dimension, false, -1);
        }
    }

    /**
     * The main method of this program. Examples of the execution of the program from the command line:
     *
     * <pre>
     * java Queens 500 100 8
     * Generations=65, Individual: {fitness=0, attributes=[5,3,0,4,7,1,6,2]}
     * </pre>
     *
     * @param args
     *            the array of arguments that were passed to the main method, generally on the command line
     */

    public static void main(final String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (final Exception e) {
        }

        StudentInfo.display();
        SwingUtilities.invokeLater(() -> Queens.execute(args));
    }

    /**
     * Implements the top-level loop of the genetic algorithm. You must complete the implementation of the method.
     * <ol>
     * <li>Create a new population</li>
     * <li>Whilst the maximum allowed number of generations has not been reached and no optimal solution has been found
     * <ol>
     * <li>Call the method evolve of the population</li>
     * </ol>
     * <li>Display the number of generations and the best individual</li>
     * </ol>
     *
     * @param generations
     *            the number of generations to simulate
     * @param size
     *            the number of individuals in the population
     * @param dimension
     *            the dimension of the chess board (also the number of queens)
     * @param gui
     *            the gui object to manipulate - if null then the simulation is text based
     */

    public static void simulate(final int generations, final int size,
            final int dimension, final boolean displayGUI) {
        try {
            new Simulation(generations, size, dimension, displayGUI).execute();
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()
                    + " Please try again.");
        }
    }
}
