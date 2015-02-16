package me.matt.jeopardy.util;

import java.nio.file.Files;
import java.nio.file.Path;

public class Database {

    public static Database readQuestions(final Path file) {
        String[] lines;
        try {
            lines = Files.readAllLines(file).toArray(new String[] {});
        } catch (final Exception e) {
            System.out
                    .println("File read error - Please ensure the file is valid.");
            return null;
        }
        int categories = Integer.parseInt(lines[0]);
        int questions = Integer.parseInt(lines[1]);
        if (lines.length != categories + (2 * questions * categories) + 2) {
            System.out.println(lines.length);
            System.out.println(categories + (2 * questions) + 2);
            return null;
        }

        final Database database = new Database(categories, questions);

        for (int i = 0; i < database.getNumCategories(); i++) {
            database.setCategory(i, lines[i + 2]);
        }
        for (int i = 0; i < database.getNumCategories(); i++) {
            for (int j = 0; j < database.getNumQuestions(); j++) {
                database.setQuestion(
                        i,
                        j,
                        new Question(
                                lines[+database.getNumCategories()
                                        + j
                                        + j
                                        + ((database.getNumQuestions() * 2) * i)],
                                lines[2
                                        + database.getNumCategories()
                                        + j
                                        + j
                                        + 1
                                        + ((database.getNumQuestions() * 2) * i)]));
            }
        }
        return database;
    }

    private final Question[][] questions;

    private final String[] categories;

    private Database(final int m, final int n) {
        categories = new String[m];
        questions = new Question[m][n];
    }

    public String getCategory(final int index) {
        return categories[index];
    }

    public int getNumCategories() {
        return categories.length;
    }

    public int getNumQuestions() {
        return questions.length;
    }

    public Question getQuestion(final int category, final int index) {
        return questions[category][index];
    }

    public void setCategory(final int index, final String category) {
        categories[index] = category;
    }

    public void setQuestion(final int category, final int index,
            final Question question) {
        questions[category][index] = question;
    }
}
