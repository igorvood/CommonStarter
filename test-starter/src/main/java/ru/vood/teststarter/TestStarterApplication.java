package ru.vood.teststarter;

import oracle.jdbc.driver.OracleDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class TestStarterApplication implements CommandLineRunner {

    @Autowired
    ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(TestStarterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> collect = Stream.of(context.getBeanDefinitionNames()).sorted().collect(Collectors.toList());
        Stream.of(context.getBeanDefinitionNames())
                .filter((s -> (s.contains("jdbc")
                                || s.contains("data"))
                                && !s.contains("springframework")
                        )

                )
                .forEach(x -> System.out.println("------------>" + x));

    }
}
