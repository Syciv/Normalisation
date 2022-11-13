package ru.film.filmopedia;

import liquibase.exception.LiquibaseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws SQLException, LiquibaseException, IOException, InterruptedException {
        SpringApplication.run(Application.class);
    }
}
