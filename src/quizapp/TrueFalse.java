package quizapp;

/**
 * represents a true/false question type
 */
public class TrueFalse extends Question {

    /**
     * creates a true/false question
     *
     * @param questionText the question text
     * @param answers array with "true"/"false"
     * @param correctAnswer the correct answer
     * @param feedback feedback message
     */
    public TrueFalse(String questionText, String[] answers, String correctAnswer, String feedback) {
        // init parent with cleaned correct answer
        super(questionText, answers, correctAnswer.trim().toLowerCase(), feedback);
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
        // return score if correct, else 0
        return isCorrect(userAnswer) ? 1 * difficulty.getMultiplier() : 0;
    }
}
