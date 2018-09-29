package net.proselyte.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExamConfig {
    @Bean
    public Exam exam(){
        return new Exam(answerChecker());
    }

    @Bean
    public AnswerChecker answerChecker(){
        return new AnswerChecker();
    }
}
