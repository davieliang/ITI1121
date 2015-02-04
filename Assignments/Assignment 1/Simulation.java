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

    public Simulation(int generations, int size, int dimension,
            boolean displayGUI) {
        this.generations = generations;
        this.size = size;
        this.displayGUI = displayGUI;
        this.startTime = System.currentTimeMillis();
        this.gui =
                displayGUI ? new FitnessGUI(dimension, true,
                        generations > 0 ? generations : -1) : null;
        this.population = new Population(size, dimension);
        if (gui != null) {
            gui.update(population.getFittest(), "Simulating....");
            gui.setTarget(population.getFittest().getFitness());
        }
        this.evolutions = 0;
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
        }
        return null;
    }

    @Override
    public void process(List<Individual> list) {
        String update =
                "There have been " + evolutions
                        + " generations and the fittest individual is "
                        + population.getFittest().getFitness() + ".";
        if (gui != null && displayGUI) {
            gui.update(list.get(list.size() - 1), generations > 0 ? evolutions
                    : list.get(list.size() - 1).getFitness());
        }
        System.out.println(update);
    }

    @Override
    protected void done() {
        final String result =
                "Printing Results..." + System.lineSeparator()
                        + System.lineSeparator() + "Execution time taken: "
                        + Util.getRuntime(startTime) + System.lineSeparator()
                        + "Generations: " + evolutions + System.lineSeparator()
                        + "Population Size: " + size + System.lineSeparator()
                        + "fitness: " + population.getFittest().getFitness()
                        + System.lineSeparator() + "Attributes: "
                        + population.getFittest().toString();
        if (displayGUI && gui != null) {
            gui.finalize(population, result);
        } else {
            System.out.println(result);
        }
    }

}
