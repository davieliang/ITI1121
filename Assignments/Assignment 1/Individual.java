import java.util.Arrays;

/**
 * An <code>Individual</code> (a chromosome) is a candidate solution for a given
 * problem. Its representation depends on the specific problem to be solved. Two
 * individuals can be combined (see method crossover) to produce a new
 * offspring. As with natural chromosomes, these artificial ones suffer
 * mutations. Each chromosome has a fitness value that indicates the quality of
 * this solution.
 * <p/>
 *
 * A <code>Population</code> is a collection of chromosomes. At each iteration (generation), the
 * genetic algorithm selects chromosomes for reproduction. The offsprings are inserted into the
 * population, and the least fitted individuals are eliminated. Thus, the size of the population is
 * fixed.
 * <p/>
 *
 * For this assignment, an <code>Individual</code> represents a solution to the <code>n</code>
 * -Queens problem. As introduced in the assignment description, a candidate solution is represented
 * by a permutation of size <code>n</code>, such that attribute <code>i</code> represents the row
 * for the queen found at column <code>i</code>.
 * <p/>
 *
 * Not all permutations are valid solutions to <code>n</code>-Queens problem. A permutation is a
 * valid solution if no two queens can attack each other. Two queens are attacking each other if
 * they are on the same row or column, which is impossible given this representation, but also if
 * they are found on the same minor or major diagonal.
 * <p/>
 *
 * Herein, we define the fitness value of an individual as the number of pairs of queens attacking
 * each other.
 * <p/>
 * You must complete the implementation of the class <code>Individual</code> following all the
 * directives.
 *
 * @author Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */

public class Individual implements Comparable<Individual> {

    private int[] positions;

    /**
     * Runs a series of tests.
     *
     * @param args
     *            command line parameters of the program
     */

    public static void main(final String[] args) {

        Individual i = new Individual(new int[] { 0, 2, 1, 3 });
        System.out.println(i.getFitness());

    }

    /**
     * Creates an <code>Individual</code> having <code>size</code> attributes.
     * This constructor is used by the class <code>Population</code>.
     *
     * @param size
     *            the number of attributes of this <code>Individual</code>
     */

    public Individual(final int size) {
        positions = Util.getPermutation(size);
    }

    /**
     * Creates an <code>Individual</code> using the provided permutation. The method
     * must copy the values of the permutation into a new array. This constructor
     * is primarily used for testing.
     *
     * @param permutation
     *            used to initialize the attributes of this <code>Individual</code>
     */

    public Individual(final int[] permutation) { // 10
        positions = permutation;

    }

    /**
     * Returns a negative integer, zero, or a positive integer as the fitness of this
     * <code>Individual</code> is
     * less than, equal to, or greater than the fitness of the specified <code>Individual</code>.
     *
     * @param other
     *            <code>Individual</code> to be compared
     * @return a negative integer, zero, or a positive integer as the fitness of this
     *         <code>Individual</code> is less than, equal to, or greater than the fitness of the
     *         specified <code>Individual</code>.
     */

    @Override
    public int compareTo(final Individual other) {
        return getFitness() - other.getFitness();
    }

    /**
     * Returns the offspring resulting from the crossover of <code>this</code>
     * <code>Individual</code> and <code>other</code>. The result must be a valid
     * permutation!
     * <p/>
     *
     * In particular, the naive solution consisting of taking the first <code>position-1</code>
     * attributes of this <code>Individual</code> and the last <code>size-position</code> attributes
     * of <code>other</code> would not generate a valid permutation in most cases.
     * <p/>
     *
     * Instead, we are proposing that the first <code>position-1</code> attributes of this
     * <code>Individual</code> are copied to the offspring, then the missing values will be selected
     * from <code>other</code>, whilst preserving their order of appearance in <code>other</code>.
     * <p/>
     *
     * This method is primarily used for testing.
     *
     * @param other
     *            a reference to an <code>Individual</code>
     * @param position
     *            the location of the crossover
     * @return the offspring resulting from the crossover of <code>this</code> and
     *         <code>other</code>
     */

    public Individual crossover(final Individual other, final int position) {

        return null;

    }

    /**
     * Returns the fitness value of <code>this Individual</code>, which
     * is defined as the number of pairs of queens attacking each
     * other.
     *
     * @return the fitness value of <code>this Individual</code>.
     */

    public int getFitness() {
        int fitnessScore = 0;
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions.length; j++) {
                if ((positions[j] == positions[i] + Math.abs(i - j) || positions[j] == positions[i]
                        - Math.abs(i - j))
                        && positions[j] != positions[i]) {
                    fitnessScore++;
                }
            }
        }
        return fitnessScore;
    }

    /**
     * Returns the offspring resulting from applying a mutation
     * to this <code>Individual</code>. In order to make sure that
     * the result is valid permutation, the method exchanges
     * the value of two randomly selected attributes.
     * <p/>
     *
     * This method is called by <code>Population</code>.
     *
     * @return the offspring resulting from exchanging two randomly selected attributes
     */

    public Individual mutate() {

        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

    }

    /**
     * Returns the offspring resulting from applying a mutation
     * to this <code>Individual</code>. In order to make sure that
     * the result is valid permutation, the method exchanges
     * the value of two attributes, those found at positions <code>i</code> and <code>j</code>.
     *
     * This method is primarily used for testing.
     *
     * @param i
     *            the first attribute
     * @param j
     *            the second attribute
     * @return the offspring resulting from exchanging attributes <code>i</code> and <code>j</code>
     */

    public Individual mutate(final int i, final int j) { // 10

        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

    }

    /**
     * Returns the offspring resulting from the crossover of <code>this</code>
     * <code>Individual</code> and <code>other</code>. The method randomly selects the
     * position of the crossover. The result must be a valid permutation!
     * <p/>
     *
     * In particular, the naive solution consisting of taking the first <code>position-1</code>
     * attributes of this <code>Individual</code> and the last <code>size-position</code> attributes
     * of <code>other</code> would not generate a valid permutation in most cases.
     * <p/>
     *
     * Instead, we are proposing that the first <code>position-1</code> attributes of this
     * <code>Individual</code> are copied to the offspring, then the missing values will be selected
     * from <code>other</code>, whilst preserving their order of appearance in <code>other</code>.
     * <p/>
     *
     * This method is used by <code>Population</code>.
     *
     * @param other
     *            a reference to an <code>Individual</code>
     * @return the offspring resulting from the crossover of <code>this</code> and
     *         <code>other</code>
     */

    public Individual recombine(final Individual other) {

        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

    }

    /**
     * Returns a string representation of this <code>Individual</code>.
     *
     * @return a string representation of this <code>Individual</code>
     */

    @Override
    public String toString() {
        return Arrays.toString(positions);
    }
}
