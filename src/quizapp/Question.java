package quizapp;

/**
 * base class for all question types
 */
public abstract class Question {
    // question text
    protected String questionText;

    // possible answers
    protected String[] answers;

    // correct answer
    protected String correctAnswer;

    // feedback message
    protected String feedback;

    /**
     * creates a question with all fields
     *
     * @param questionText the question
     * @param answers list of answer choices
     * @param correctAnswer the correct answer
     * @param feedback feedback to show
     */
    public Question(String questionText, String[] answers, String correctAnswer, String feedback) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswer = correctAnswer.toLowerCase(); // force lowercase
        this.feedback = feedback;
    }

    /**
     * calculates score based on user answer and difficulty
     *
     * @param userAnswer user’s answer
     * @param difficulty selected difficulty
     * @return score earned
     */
    public abstract double calculateScore(String userAnswer, Difficulty difficulty);

    /**
     * checks if user answer is correct
     *
     * @param userAnswer answer to check
     * @return true if correct
     */
    public boolean isCorrect(String userAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }

    /**
     * gets the question text
     *
     * @return question text
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * gets the possible answers
     *
     * @return array of answers
     */
    public String[] getAnswers() {
        return answers;
    }

    /**
     * gets the feedback text
     *
     * @return feedback
     */
    public String getFeedback() {
        return feedback;
    }
}
