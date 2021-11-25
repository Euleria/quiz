package pl.euleria.quiz;

import java.util.ArrayList;

public class Question {
    private String content;
    private ArrayList<Answer> answerList;

    public Question(String content) {
        this.content = content;
        answerList = new ArrayList<>();
    }

    public Question(String content, ArrayList<Answer> answerList) {
        this.content = content;
        this.answerList = answerList;
    }

    public ArrayList<Answer> getAnswerList() {
        return answerList;
    }

    public String getContent() {
        return content;
    }

    public void addAnswer (Answer answer) {
        this.answerList.add(answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + content + '\'' +
                ", answerList=" + answerList +
                '}';
    }
}
