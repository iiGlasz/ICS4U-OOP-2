package quizapp;

/**
 * represents a multiple choice question
 */
public class MultipleChoice extends Question {

    /**
     * creates a multiple choice question
     *
     * @param questionText the question
     * @param answers answer choices
     * @param correctAnswer the correct choice
     * @param feedback feedback message
     */
    public MultipleChoice(String questionText, String[] answers, String correctAnswer, String feedback) {
        // call parent with trimmed, lowercase answer
        super(questionText, answers, correctAnswer.trim().toLowerCase(), feedback);
    }

    /**
     * calculates score based on answer and difficulty
     *
     * @param userAnswer user's answer
     * @param difficulty selected difficulty
     * @return score earned
     */
    @Override
    public double calculateScore(String userAnswer, Difficulty difficulty) {
        // full score if correct
        return isCorrect(userAnswer) ? 1 * difficulty.getMultiplier() : 0;
    }
}
