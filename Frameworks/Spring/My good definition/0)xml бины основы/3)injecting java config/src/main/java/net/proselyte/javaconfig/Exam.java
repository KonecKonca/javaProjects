package net.proselyte.javaconfig;

public class Exam {
    private AnswerChecker answerChecker;

    public Exam(AnswerChecker answerChecker) {
        System.out.println("Exam constructor.");
        this.answerChecker = answerChecker;
    }

    public AnswerChecker getAnswerChecker() {
        return answerChecker;
    }

    public void examCheck() {
        answerChecker.checkAnswer();
    }
}
