package pl.euleria.quiz;

import java.util.ArrayList;

public class Category {
    private String name;
    private ArrayList<Question> questionList;

    public Category(String name) {
        this.name = name;
        questionList = new ArrayList<>();
    }

    public Category(String name, ArrayList<Question> questionList) {
        this.name = name;
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category='" + name + '\'' +
                ", questionList=" + questionList +
                '}';
    }

    public void addQuestion (Question question) {
        this.questionList.add(question);
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public String getName() {
        return name;
    }

}
