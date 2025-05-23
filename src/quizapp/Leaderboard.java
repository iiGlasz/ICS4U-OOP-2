package quizapp;

import java.io.*;
import java.util.ArrayList;

/**
 * manages leaderboard data by reading/writing user scores
 */
public class Leaderboard {
    // file storing scores
    private File allScores;

    // list of all users
    private ArrayList<User> users;

    /**
     * creates leaderboard from a file
     *
     * @param filename name of the file
     */
    public Leaderboard(String filename) {
        allScores = new File("src/data/" + filename);
        users = new ArrayList<>();

        // load file if it exists
        if (allScores.exists()) {
            readFile(filename);
        } else {
            System.out.println("leaderboard file not found. a new one will be created when updated.");
        }
    }

    /**
     * adds or updates a user in the leaderboard
     *
     * @param newUser user to add or update
     */
    public void addUser(User newUser) {
        readFile("leaderboard.txt");

        // check for existing user
        for (int i = 0; i < users.size(); i++) {
            User existingUser = users.get(i);
            if (existingUser.getName().equals(newUser.getName())) {
                // replace if score is higher
                if (newUser.getScore() > existingUser.getScore()) {
                    users.set(i, newUser);
                }
                // save updated list
                updateFile(allScores.getName(), users.toArray(new User[0]));
                return;
            }
        }

        // add new user
        users.add(newUser);
        updateFile(allScores.getName(), users.toArray(new User[0]));
    }

    /**
     * returns top users in formatted string
     *
     * @return leaderboard string
     */
    public String getFormattedTopUsers() {
        // sort by score descending
        users.sort((a, b) -> Integer.compare(b.getScore(), a.getScore()));

        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(user.getName()).append(": ").append(user.getScore()).append("\n");
        }
        return sb.toString();
    }

    /**
     * reads user data from file
     *
     * @param filename file to read
     */
    public void readFile(String filename) {
        users.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/data/" + filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // parse each line
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    users.add(new User(score, name));
                }
            }
        } catch (IOException e) {
            System.out.println("error reading leaderboard file.");
            e.printStackTrace();
        }
    }

    /**
     * writes user data to file
     *
     * @param filename file to write to
     * @param userArray array of users
     */
    public void updateFile(String filename, User[] userArray) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/" + filename))) {
            for (User user : userArray) {
                // write each user
                writer.write(user.getName() + "," + user.getScore());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("error writing to leaderboard file.");
            e.printStackTrace();
        }
    }
}
