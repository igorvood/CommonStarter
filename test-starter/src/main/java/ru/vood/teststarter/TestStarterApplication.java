package ru.vood.teststarter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestStarterApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestStarterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
