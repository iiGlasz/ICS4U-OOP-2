package quizapp;

public class User {
    private int score;
    private String name;
    private static int totalUsers = 0;
    private static final String DEFAULT_NAME = "---";

    public User(int score, String name) {
        this.score = score;
        this.name = (name == null || name.isBlank()) ? DEFAULT_NAME : name;
        totalUsers++;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore(int value) {
        score += value;
    }

    public static int getTotalUsers() {
        return totalUsers;
    }

    public String getName() {
        return name;
    }
}
