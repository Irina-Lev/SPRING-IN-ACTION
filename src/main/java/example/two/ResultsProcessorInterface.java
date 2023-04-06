package example.two;

import java.io.IOException;
import java.util.List;

public interface ResultsProcessorInterface {
    void readRightAnswers(String filePath) throws IOException;
    long countGrades(List<Answers> answers);
}
