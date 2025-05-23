package quizapp;

import java.io.*;
import java.util.ArrayList;

public class Leaderboard {
    private File allScores;
    private ArrayList<User> users;

    public Leaderboard(String filename) {
        allScores = new File("src/data/" + filename);
        users = new ArrayList<>();

        if (allScores.exists()){
            readFile(filename);
        } else {
            System.out.println("Leaderboard file not found. A new one will be created when updated.");
        }
    }

    public void addUser(User newUser) {
        readFile("leaderboard.txt");
        for (int i = 0; i < users.size(); i++) {
            User existingUser = users.get(i);
            if (existingUser.getName().equals(newUser.getName())) {
                // Update the score if new one is higher
                if (newUser.getScore() > existingUser.getScore()) {
                    users.set(i, newUser);
                }
                updateFile(allScores.getName(), users.toArray(new User[0]));
                return;
            }
        }

        // New user
        users.add(newUser);
        updateFile(allScores.getName(), users.toArray(new User[0]));
    }

    public String getFormattedTopUsers() {
        users.sort((a, b) -> Integer.compare(b.getScore(), a.getScore()));

        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(user.getName()).append(": ").append(user.getScore()).append("\n");
        }
        return sb.toString();
    }

    public void readFile(String filename) {
        users.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/data/" + filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    users.add(new User(score, name));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading leaderboard file.");
            e.printStackTrace();
        }
    }

    public void updateFile(String filename, User[] userArray) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/" + filename))) {
            for (User user : userArray) {
                writer.write(user.getName() + "," + user.getScore());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to leaderboard file.");
            e.printStackTrace();
        }
    }
}
