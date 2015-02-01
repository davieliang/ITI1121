import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * The class <b>Queens</b> implements the top-level of the genetic algorithm. It has a main method that reads parameters from the command line or
 * using input dialogs. Here is a sample run.
 *
 * <pre>
 * > java Queens 500 100 8
 * Generations=65, Individual: {fitness=0, attributes=[5,3,0,4,7,1,6,2]}
 * </pre>
 *
 * Because of the ``probabilistic'' nature of the algorithm, each run is likely to produce a new solution.
 *
 * @author Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */

public class Queens {

    /**
     * The main method of this program. Examples of the execution of the program from the command line:
     *
     * <pre>
     * > java Queens 500 100 8
     * Generations=65, Individual: {fitness=0, attributes=[5,3,0,4,7,1,6,2]}
     * </pre>
     *
     * @param args
     *            the array of arguments that were passed to the main method, generally on the command line
     */

    public static void main(final String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        StudentInfo.display();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                int generations, size, dimension;
                GUI gui;
                if (args.length == 3) {
                    generations = Integer.parseInt(args[0]);
                    size = Integer.parseInt(args[1]);
                    dimension = Integer.parseInt(args[2]);
                }

                // Custom button text
                final String[] options = { "GUI", "Text Based",
                        "Fitness Checker" };
                String s = (String) JOptionPane.showInputDialog(null, "",
                        "Method Selection", JOptionPane.PLAIN_MESSAGE, null,
                        options, "ham");
                if (s == null) {
                    System.exit(0);
                }
                switch (s) {
                    case "GUI":
                        generations = Integer.parseInt(JOptionPane
                                .showInputDialog(
                                        "Input the number of generations. -1 for infinite",
                                        "500"));
                        size = Integer.parseInt(JOptionPane.showInputDialog(
                                "Input the size of the population", "100"));
                        dimension = Integer.parseInt(JOptionPane
                                .showInputDialog(
                                        "Input the dimension of the board", "8"));
                        gui = new GUI(dimension);
                        Queens.simulate(generations, size, dimension, gui);
                        break;
                    case "Text Based":
                        generations = Integer.parseInt(JOptionPane
                                .showInputDialog(
                                        "Input the number of generations. -1 for infinite",
                                        "500"));
                        size = Integer.parseInt(JOptionPane.showInputDialog(
                                "Input the size of the population", "100"));
                        dimension = Integer.parseInt(JOptionPane
                                .showInputDialog(
                                        "Input the dimension of the board", "8"));
                        Queens.simulate(generations, size, dimension, null);
                        break;
                    case "Fitness Checker":
                        dimension = Integer.parseInt(JOptionPane
                                .showInputDialog(
                                        "Input the dimension of the board", "8"));
                        gui = new GUI(dimension, true);
                        break;
                }
            }
        });
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
            final int dimension, GUI gui) {
        Population p = new Population(size, dimension);
        int evolutions = 0;
        while (true) {
            if (evolutions == generations) {
                break;
            }
            if (gui != null) {
                gui.update("There have been " + evolutions
                        + " generations and the fittest individual is "
                        + p.getFittest().getFitness() + ".", p.getFittest());
            } else {
                System.out.println("There have been " + evolutions
                        + " generations and the fittest individual is "
                        + p.getFittest().getFitness() + ".");
            }
            if (p.getFittest().getFitness() == 0) {
                break;
            }
            p.evolve();
            evolutions++;
        }
        if (gui != null) {
            gui.update(
                    "Generations: " + evolutions + System.lineSeparator()
                            + "fitness: " + p.getFittest().getFitness()
                            + System.lineSeparator() + "Attributes: "
                            + p.getFittest().toString(), p.getFittest());
        } else {
            System.out.println("Generations: " + evolutions
                    + System.lineSeparator() + "fitness: "
                    + p.getFittest().getFitness() + System.lineSeparator()
                    + "Attributes: " + p.getFittest().toString());
        }

    }

}
