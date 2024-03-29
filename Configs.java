import java.util.*;

public class Configs {
    // Immutable parameters:
    /**
     * Dimension of the solution vector to the problem. (1 x N)
     */
    private final int dimension = 10;

    /**
     * Additional dimention to the solution vector to encode different values.
     */
    private final int addtionalDimension = 56;

    /**
     * Public flag for debugging.
     */
    private final boolean DEBUG = true;

    /**
     * Lower bound of domain for each element in the solution vector.
     */
    private final int lowerBound = -5;

    /**
     * Upper bound of domain for each element in the solution vector.
     */
    private final int upperBound = 5;

    // Mutable parameters:
    /**
     * Total number of individuals of each generation.
     */
    private int populationSize;

    /**
     * Size of Tournament.
     */
    private int tournamentSize;

    /**
     * Rate of occurence for mutation for each child.
     */
    private double mutationRate;

    /**
     * Number of dimensions to mutate during mutation.
     */
    private int mutationSize;

    /**
     * Learning rate for single uncorrelated self-adaptive mutation methods.
     */
    private double singleMutationLearningRate;

    /**
     * Overall learning rate for self-adaptive mutation methods.
     */
    private double mutationLearningRate;

    /**
     * Number of randomly selected candidates for parent selections based on
     * Elitism.
     */
    private int randomSelected;

    /**
     * Number of parents selected for reproduction.
     */
    private int parentSelected;

    /**
     * Mixing factor for some mutation methods(e.g. single/simple/whole arithmetic
     * mutation and blend crossover).
     */
    private double mixingFactor;

    /**
     * Coefficient factor for the Single Uncorrelated Mutation (p1).
     */
    private double singleMutationCoefficient;

    /**
     * Overall coefficient factor for the Multi Uncorrelated Mutation and Correlated
     * Mutation (p2).
     */
    private double overallMutationCoefficient;

    /**
     * Secondary coefficient factor for the Multi Uncorrelated Mutation and
     * Correlated Mutation (p3).
     */
    private double secondaryMutationCoefficient;

    /**
     * Standard deviation during initialization of the population.
     */
    private double initSigma;

    /**
     * Lower bound for mutation step size to avoid tending to 0.
     */
    private double mutationStepSizeBound;

    /**
     * Coordinate wise learning rate for self-adaptive mutations.
     */
    private double secondaryMutationLearningRate;

    /**
     * A factor to measure advantage of best individual (set from 1.0 ~ 2.0)
     */
    private double s_value;
    
    /**
     * The initial value of mutation step size.
     */
    private double initialStepSize;

    /**
     * Covarience matrix for self-apative correlated mutation.
     */
    private double[][] covarienceMatrix;

    /**
     * Correlation angle for self-adaptive correlated mutation.
     */
    private double correlationAngle;

    public Configs() {
    }

    public void initParams() {
        setInitSigma(2);
        setSingleMutationLearningRate(1 / Math.sqrt(this.dimension));
        setMutationLearningRate(1 / Math.sqrt(2 * this.dimension));
        setSecondaryMutationLearningRate(1 / Math.sqrt(2 * Math.sqrt(this.dimension)));
        setS_value(1.9); // should be in range (0, 2].
        initCovarianceMatrix();
        setCorrelationAngle(Math.toRadians(5));
    }

    public int getPopulationSize() {
        return this.populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public int getDimension() {
        return this.dimension;
    }

    public int getAdditionalDimension() {
        return this.addtionalDimension;
    }

    public boolean getDEBUG() {
        return this.DEBUG;
    }

    public int getLowerBound() {
        return this.lowerBound;
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public int getTournamentSize() {
        return this.tournamentSize;
    }

    public void setTournamentSize(int tournamentSize) {
        this.tournamentSize = tournamentSize;
    }

    public double getMutationRate() {
        return this.mutationRate;
    }

    public void setMutationRate(double mutationRate) {
        this.mutationRate = mutationRate;
    }

    public double getSingleMutationCoefficient() {
        return this.singleMutationCoefficient;
    }

    public void setSingleMutationCoefficient(double singleMutationCoefficient) {
        this.singleMutationCoefficient = singleMutationCoefficient;
    }

    public double getOverallMutationCoefficient() {
        return this.overallMutationCoefficient;
    }

    public void setOverallMutationCoefficient(double overallMutationCoefficient) {
        this.overallMutationCoefficient = overallMutationCoefficient;
    }

    public double getSecondaryMutationCoefficient() {
        return this.secondaryMutationCoefficient;
    }

    public void setSecondaryMutationCoefficient(double secondaryMutationCoefficient) {
        this.secondaryMutationCoefficient = secondaryMutationCoefficient;
    }
    
    public double getInitialStepSize() {
        return this.initialStepSize;
    }

    public void setInitialStepSize(double initialStepSize) {
        this.initialStepSize = initialStepSize;
    }

    public int getMutationSize() {
        return this.mutationSize;
    }

    public void setMutationSize(int mutationSize) {
        this.mutationSize = mutationSize;
    }

    public int getRandomSelected() {
        return this.randomSelected;
    }

    public void setRandomSelected(int randomSelected) {
        this.randomSelected = randomSelected;
    }

    public int getParentSelected() {
        return this.parentSelected;
    }

    public void setParentSelected(int parentSelected) {
        this.parentSelected = parentSelected;
    }

    public double getMixingFactor() {
        return this.mixingFactor;
    }

    public void setMixingFactor(double mixingFactor) {
        this.mixingFactor = mixingFactor;
    }

    public double getInitSigma() {
        return this.initSigma;
    }

    public void setInitSigma(double initSigma) {
        this.initSigma = initSigma;
    }

    public double getSingleMutationLearningRate() {
        return this.singleMutationLearningRate;
    }

    public void setSingleMutationLearningRate(double singleMutationLearningRate) {
        this.singleMutationLearningRate = singleMutationLearningRate;
    }

    public double getMutationLearningRate() {
        return this.mutationLearningRate;
    }

    public void setMutationLearningRate(double mutationLearningRate) {
        this.mutationLearningRate = mutationLearningRate;
    }

    public double getMutationStepSizeBound() {
        return this.mutationStepSizeBound;
    }

    public void setMutationStepSizeBound(double mutationStepSizeBound) {
        this.mutationStepSizeBound = mutationStepSizeBound;
    }

    public double getSecondaryMutationLearningRate() {
        return this.secondaryMutationLearningRate;
    }

    public void setSecondaryMutationLearningRate(double secondaryMutationLearningRate) {
        this.secondaryMutationLearningRate = secondaryMutationLearningRate;
    }

    public double getS_value() {
        return this.s_value;
    }

    public void setS_value(double s_value) {
        this.s_value = s_value;
    }

    public void initCovarianceMatrix() {
        this.covarienceMatrix = new double[this.dimension][this.dimension];
    }

    public double[][] getCovarienceMatrix() {
        return this.covarienceMatrix;
    }

    public void setCovarianceMatrix(double[] ndMutationStepSize, double[] correlationFactors) {
        int indCounter = 0;
        for (int i = 0; i < this.dimension; i++) {
            for (int j = i; j < this.dimension; j++) {
                if (j == i) {
                    this.covarienceMatrix[i][j] = ndMutationStepSize[i] * ndMutationStepSize[i];
                } else {
                    this.covarienceMatrix[i][j] = 0.5
                            * (ndMutationStepSize[i] * ndMutationStepSize[i]
                                    - ndMutationStepSize[j] * ndMutationStepSize[j])
                            * Math.tan(2 * correlationFactors[indCounter]);
                    this.covarienceMatrix[j][i] = 0.5
                            * (ndMutationStepSize[j] * ndMutationStepSize[j]
                                    - ndMutationStepSize[i] * ndMutationStepSize[i])
                            * Math.tan(2 * correlationFactors[indCounter]);
                    indCounter++;
                }
            }
        }
        // System.out.println(Arrays.deepToString(covarienceMatrix));
    }

    public double getCorrelationAngle() {
        return this.correlationAngle;
    }

    public void setCorrelationAngle(double correlationAngle) {
        this.correlationAngle = correlationAngle;
    }

}
