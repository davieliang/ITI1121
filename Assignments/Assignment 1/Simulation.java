import java.util.List;

import javax.swing.SwingWorker;

public class Simulation extends SwingWorker<Void, Long> {

    private final int generations;
    private final boolean displayGUI;
    private long evolutions;
    private final long startTime;
    private final Population population;
    private final SimulationGUI sim;
    private final int size;

    public Simulation(int generations, int size, int dimension,
            boolean displayGUI) {
        this.generations = generations;
        this.size = size;
        this.displayGUI = displayGUI;
        this.sim = displayGUI ? new SimulationGUI(generations) : null;
        this.startTime = System.currentTimeMillis();
        this.population = new Population(size, dimension);
        this.evolutions = 0;
    }

    @Override
    protected Void doInBackground() throws Exception {
        while (true) {
            this.publish(generations > 0 ? evolutions : population.getFittest()
                    .getFitness());
            if (evolutions == generations) {
                break;
            }
            System.out.println("There have been " + evolutions
                    + " generations and the fittest individual is "
                    + population.getFittest().getFitness() + ".");
            if (population.getFittest().getFitness() == 0) {
                break;
            }
            population.evolve();
            evolutions++;
        }
        return null;
    }

    @Override
    public void process(List<Long> list) {
        if (sim != null && displayGUI) {
            sim.update(list.get(list.size() - 1));
        }
    }

    @Override
    protected void done() {
        final String result = "Execution time taken: "
                + Util.getRuntime(startTime) + System.lineSeparator()
                + "Generations: " + evolutions + System.lineSeparator()
                + "Population Size: " + size + System.lineSeparator()
                + "fitness: " + population.getFittest().getFitness()
                + System.lineSeparator() + "Attributes: "
                + population.getFittest().toString();
        if (displayGUI) {
            sim.dispose();
            new FitnessGUI(population.getFittest(), result);
        }
        System.out.println(result);
    }

}
