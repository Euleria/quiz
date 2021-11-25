package pl.euleria.quiz;

public class Answer {
    private String content;
    private int value;

    public Answer(String content, int value) {
        this.content = content;
        this.value = value;
    }

    public String getContent() {
        return content;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + content + '\'' +
                ", value=" + value +
                '}';
    }
}
