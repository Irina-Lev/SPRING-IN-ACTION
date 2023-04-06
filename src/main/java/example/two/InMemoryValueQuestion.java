package example.two;

import java.util.Map;

public class InMemoryValueQuestion implements ValueQuestion {
    private final Map<String, String> valueQuestions;

    public InMemoryValueQuestion( Map<String, String> valueQuestions) {
        this.valueQuestions = valueQuestions;
    }

    @Override
    public String valueRightAnswers(String number) {
        return valueQuestions.get(number);
    }
}