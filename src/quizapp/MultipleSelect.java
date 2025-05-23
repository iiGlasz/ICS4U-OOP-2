package quizapp;

public class MultipleSelect extends Question {

    public MultipleSelect(String questionText, String[] answers, String correctAnswers, String feedback) {
        super(questionText, answers, correctAnswers, feedback);
    }

    @Override
    public double calculateScore(String userAnswer, Difficulty difficulty) {
        return isCorrect(userAnswer) ? 1 * difficulty.getMultiplier() : 0;
    }
}
