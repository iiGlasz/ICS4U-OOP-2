package quizapp;

/**
 * represents a user in the quiz app with a name and score
 */
public class User {
    // user score
    private int score;

    // user name
    private String name;

    // total users made
    private static int totalUsers = 0;

    // default name if blank
    private static final String DEFAULT_NAME = "---";

    /**
     * creates a user with score and name
     *
     * @param score initial score
     * @param name user name
     */
    public User(int score, String name) {
        this.score = score;
        // use default if name is blank
        this.name = (name == null || name.isBlank()) ? DEFAULT_NAME : name;
        // count new user
        totalUsers++;
    }

    /**
     * gets user score
     *
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * adds to score
     *
     * @param value score to add
     */
    public void incrementScore(int value) {
        score += value;
    }

    /**
     * gets total user count
     *
     * @return total users
     */
    public static int getTotalUsers() {
        return totalUsers;
    }

    /**
     * gets user name
     *
     * @return name
     */
    public String getName() {
        return name;
    }
}
