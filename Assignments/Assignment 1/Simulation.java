import java.util.List;

import javax.swing.SwingWorker;

public class Simulation extends SwingWorker<Void, Individual> {

    private final int generations;
    private final boolean displayGUI;
    private long evolutions;
    private final long startTime;
    private final Population population;
    private final FitnessGUI gui;
    private final int size;
    private final int dimension;

    public Simulation(final int generations, final int size,
            final int dimension, final boolean displayGUI) {
        this.generations = generations;
        this.size = size;
        this.dimension = dimension;
        this.displayGUI = displayGUI;
        startTime = System.currentTimeMillis();
        gui =
                displayGUI ? new FitnessGUI(dimension, true,
                        generations > 0 ? generations : -1) : null;
        population = new Population(size, dimension);
        if (gui != null) {
            gui.update(population.getFittest(), "Simulating....",
                    MessageType.INFO);
            if (generations > 0) {
                gui.log("The simulation has artifically been slowed down for viewer use!",
                        MessageType.WARNING);
            }
            gui.setTarget(population.getFittest().getFitness());
        }
        evolutions = 0;
    }

    @Override
    protected Void doInBackground() throws Exception {
        while (true) {
            this.publish(population.getFittest());
            if (evolutions == generations) {
                break;
            }
            if (population.getFittest().getFitness() == 0) {
                break;
            }
            population.evolve();
            evolutions++;
            if (displayGUI && generations > 0) {
                Thread.sleep(20);
            }
        }
        return null;
    }

    @Override
    protected void done() {
        population.finalize();
        final String result =
                "Execution time taken: " + Util.getRuntime(startTime)
                        + System.lineSeparator() + "Generations: " + evolutions
                        + System.lineSeparator() + "Population Size: " + size
                        + System.lineSeparator() + "Dimension: " + dimension
                        + System.lineSeparator() + "Attributes: "
                        + population.getFittest().toString();
        if (displayGUI && gui != null) {
            gui.finalize(population, result);
        } else {
            System.out.println(result);
        }
    }

    @Override
    public void process(final List<Individual> list) {
        final String update =
                "There have been " + evolutions
                        + " generations and the fittest individual is "
                        + population.getFittest().getFitness() + ".";
        if (gui != null && displayGUI) {
            gui.update(list.get(list.size() - 1), generations > 0 ? evolutions
                    : list.get(list.size() - 1).getFitness());
        }
        System.out.println(update);
    }

}
