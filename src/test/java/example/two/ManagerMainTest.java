package example.two;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

import static org.junit.Assert.*;

public class ManagerMainTest {

    @Test
    public void main() throws IOException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ManagerConfig.class);
        var inMemoryResultParser = applicationContext.getBean(ResultsProcessor.class);
        inMemoryResultParser.readRightAnswers("right-answers.txt");
        var answers = inMemoryResultParser.readFromFile("answers.txt");
        var result = inMemoryResultParser.countGrades(answers);
        Assert.assertEquals(result, 15 );
    }
}