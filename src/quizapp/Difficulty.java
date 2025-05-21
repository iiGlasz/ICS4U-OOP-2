package quizapp;

public class Difficulty {
    private String level;
    private double multiplier;

    public Difficulty(String level, double multiplier) {
        this.level = level;
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public String getLevel() {
        return level;
    }
}
