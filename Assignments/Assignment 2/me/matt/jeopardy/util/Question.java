package me.matt.jeopardy.util;

/**
 *
 * A wrapper for a question in Jeopardy. Represents a question to be asked and a response to said question.
 *
 * Assignment: 2
 * Course: ITI1121 Section 1
 * Student no: 7731813
 * 
 * @author Matt Langlois (Fletchto99@gmail.com)
 *
 */
public class Question {

    private final String question;

    private final String answer;

    /**
     * @param question
     *            The question being asked.
     * @param answer
     *            The answer to the question
     */
    public Question(final String question, final String answer) {
        this.question = question;
        this.answer = answer;
    }

    /**
     * Fetches the question being asked
     *
     * @return The question being asked
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Fetches the valid response to the question
     *
     * @return The answer to the question
     */
    public String getResponse() {
        return answer;
    }

}
