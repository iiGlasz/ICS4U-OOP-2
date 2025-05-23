package quizapp;

/**
 * represents a multiple select question
 */
public class MultipleSelect extends Question {

    /**
     * creates a multiple select question
     *
     * @param questionText the question
     * @param answers list of choices
     * @param correctAnswers correct answers (comma or space separated)
     * @param feedback feedback message
     */
    public MultipleSelect(String questionText, String[] answers, String correctAnswers, String feedback) {
        // call parent constructor
        super(questionText, answers, correctAnswers, feedback);
    }

    /**
     * calculates score based on answer and difficulty
     *
     * @param userAnswer answer given by user
     * @param difficulty question difficulty
     * @return score earned
     */
    @Override
    public double calculateScore(String userAnswer, Difficulty difficulty) {
        // full score if correct, else 0
        return isCorrect(userAnswer) ? 1 * difficulty.getMultiplier() : 0;
    }
}
