package model;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String question;
    private String category;
    private String correctAnswer;
    private List<String> answers;

    public Question(String question, String category, String correctAnswer, List<String> answers) {
        this.answers = answers;
        setCorrectAnswer(correctAnswer);
        setQuestion(question);
        setCategory(category);
    }

    private void setCorrectAnswer(String correctanswer) {
        this.correctAnswer = correctanswer;
    }

    private String getCorrectanswer() {
        return this.correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    private void setQuestion(String question) {
        this.question = question;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getAnswers() {
        return this.answers;
    }

    public void addAnswers(List<String> answers) {
        this.answers.addAll(answers);
    }

    private void setCategory(String category) {
        this.category = category;
    }


}
