package example.two;


import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultsProcessor implements ResultsProcessorInterface {
    private final Map<String, Character> mapRightAnswers;
private final ValueQuestion valueQuestion;

    public ResultsProcessor(ValueQuestion valueQuestion) {
        this.valueQuestion = valueQuestion;
        this.mapRightAnswers = new HashMap<>();
    }



    public void readRightAnswers(String fileName) throws IOException {
        var filePath = new ClassPathResource(fileName).getFile().toPath().toString();
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("-", 2);
            var question = parts[0].trim();
            var answer = parts[1].replace(",", "").trim().charAt(0);
            mapRightAnswers.put(question, answer);
        }
    }

    public Answers readAnswers(String line) {
        String[] parts = line.split("-", 2);
        var question = parts[0].trim();
        var answer = parts[1].replace(",", "").trim().charAt(0);
        var answerRight = mapRightAnswers.get(question);
        int value =0;
        if (answerRight.equals(answer)) {
            value = Integer.parseInt(valueQuestion.valueRightAnswers(question));
        }
        return new Answers(question, answer, value);
    }



    public List<Answers> readFromFile(String fileName) throws IOException {
        List <Answers>  listAnswers = new ArrayList<Answers>();
        var filePath = new ClassPathResource(fileName).getFile().toPath().toString();
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null) {
            listAnswers.add(readAnswers(line));
        }
        return listAnswers;
    }

    @Override
    public long countGrades(List<Answers> answers) {
        return   answers.stream().mapToLong(e ->e.getValue()).sum();
    }

}





