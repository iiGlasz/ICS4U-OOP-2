package quizapp;

public class MultipleChoice extends Question {

    public MultipleChoice(String questionText, String[] answers, String correctAnswer, String feedback) {
        super(questionText, answers, correctAnswer.trim().toLowerCase(), feedback);
    }

    @Override
    public double calculateScore(String userAnswer, Difficulty difficulty) {
        return isCorrect(userAnswer) ? 1 * difficulty.getMultiplier() : 0;
    }
}
