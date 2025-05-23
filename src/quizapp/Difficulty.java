package quizapp;

/**
 * represents a difficulty level with a score multiplier
 */
public class Difficulty {
    // difficulty label (e.g. easy, hard)
    private String level;

    // score multiplier
    private double multiplier;

    /**
     * creates a difficulty setting
     *
     * @param level difficulty name
     * @param multiplier score multiplier
     */
    public Difficulty(String level, double multiplier) {
        this.level = level;
        this.multiplier = multiplier;
    }

    /**
     * gets the multiplier value
     *
     * @return score multiplier
     */
    public double getMultiplier() {
        return multiplier;
    }

    /**
     * gets the difficulty level
     *
     * @return difficulty name
     */
    public String getLevel() {
        return level;
    }
}
