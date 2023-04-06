package example.two;

import java.util.stream.IntStream;

public class Answers {
    String kodQuestion;
    Character answer;
    int value;

    public Answers(String kodQuestion, Character answer, int value) {
        this.kodQuestion = kodQuestion;
        this.answer = answer;
        this.value = value;
    }



    public String getKodQuestion() {
        return kodQuestion;
    }

    public Character getAnswer() {
        return answer;
    }

    public int getValue() {
        return value;
    }

    public void setKodQuestion(String kodQuestion) {
        this.kodQuestion = kodQuestion;
    }

    public void setAnswer(Character answer) {
        this.answer = answer;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
