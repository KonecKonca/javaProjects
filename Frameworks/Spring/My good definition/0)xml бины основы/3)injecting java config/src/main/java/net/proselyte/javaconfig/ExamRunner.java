package net.proselyte.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExamRunner {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ExamConfig.class);

        Exam exam = (Exam) context.getBean(Exam.class);
        exam.examCheck();
    }
}
