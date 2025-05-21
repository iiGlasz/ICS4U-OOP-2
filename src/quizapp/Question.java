package quizapp;

public abstract class Question {
    protected String questionText;
    protected String[] answers;
    protected String correctAnswer;
    protected String feedback;

    public Question(String questionText, String[] answers, String correctAnswer, String feedback) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswer = correctAnswer.toLowerCase(); // force lowercase
        this.feedback = feedback;
    }

    public abstract double calculateScore(String userAnswer, Difficulty difficulty);

    public boolean isCorrect(String userAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getAnswers() {
        return answers;
    }

    public String getFeedback() {
        return feedback;
    }
}
