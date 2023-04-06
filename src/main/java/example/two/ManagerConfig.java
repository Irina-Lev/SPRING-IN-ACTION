package example.two;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PropertiesConfiguration.class)
public class ManagerConfig {
@Value("#{${question.value}}")
private Map<String, String> valueQuestions;
    @Bean
    public ValueQuestion valueQuestion() {return new InMemoryValueQuestion(valueQuestions);}

    @Bean
    public ResultsProcessorInterface resultParser() { return new ResultsProcessor(valueQuestion());}
}