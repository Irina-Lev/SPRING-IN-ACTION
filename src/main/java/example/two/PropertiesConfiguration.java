package example.two;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.swing.*;

@Configuration
@PropertySource("classpath:question-value.properties")
public class PropertiesConfiguration {
}
