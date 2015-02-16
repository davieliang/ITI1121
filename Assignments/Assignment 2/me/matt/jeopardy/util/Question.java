package me.matt.jeopardy.util;

public class Question {

    private final String question;

    private final String answer;

    public Question(final String question, final String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getResponse() {
        return answer;
    }

}
