package example.two;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.io.IOException;

public class ManagerMain {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ManagerConfig.class);
        var inMemoryResultParser = applicationContext.getBean(ResultsProcessor.class);
        inMemoryResultParser.readRightAnswers("right-answers.txt");
        var answers = inMemoryResultParser.readFromFile("answers.txt");
        var result = inMemoryResultParser.countGrades(answers);

        System.out.println("Number of points: " + result);
    }
}
