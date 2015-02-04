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

    public Simulation(final int generations, final int size,
            final int dimension, final boolean displayGUI) {
        this.generations = generations;
        this.size = size;
        this.displayGUI = displayGUI;
        this.startTime = System.currentTimeMillis();
        this.gui = displayGUI ? new FitnessGUI(dimension, true,
                generations > 0 ? generations : -1) : null;
        this.population = new Population(size, dimension);
        if (this.gui != null) {
            this.gui.update(this.population.getFittest(), "Simulating....");
            this.gui.setTarget(this.population.getFittest().getFitness());
        }
        this.evolutions = 0;
    }

    @Override
    protected Void doInBackground() throws Exception {
        while (true) {
            this.publish(this.population.getFittest());
            if (this.evolutions == this.generations) {
                break;
            }
            if (this.population.getFittest().getFitness() == 0) {
                break;
            }
            this.population.evolve();
            this.evolutions++;
        }
        return null;
    }

    @Override
    protected void done() {
        this.population.finalize();
        final String result = "Printing Results..." + System.lineSeparator()
                + System.lineSeparator() + "Execution time taken: "
                + Util.getRuntime(this.startTime) + System.lineSeparator()
                + "Generations: " + this.evolutions + System.lineSeparator()
                + "Population Size: " + this.size + System.lineSeparator()
                + "fitness: " + this.population.getFittest().getFitness()
                + System.lineSeparator() + "Attributes: "
                + this.population.getFittest().toString();
        if (this.displayGUI && this.gui != null) {
            this.gui.finalize(this.population, result);
        } else {
            System.out.println(result);
        }
    }

    @Override
    public void process(final List<Individual> list) {
        final String update = "There have been " + this.evolutions
                + " generations and the fittest individual is "
                + this.population.getFittest().getFitness() + ".";
        if (this.gui != null && this.displayGUI) {
            this.gui.update(
                    list.get(list.size() - 1),
                    this.generations > 0 ? this.evolutions : list.get(
                            list.size() - 1).getFitness());
        }
        System.out.println(update);
    }

}
