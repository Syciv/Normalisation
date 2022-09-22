package ru.film.filmopedia;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import ru.film.filmopedia.repository.FilmRepository;
import ru.film.filmopedia.repository.FilmopediaRepository;
import ru.film.filmopedia.tables.pojos.Film;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

import static org.postgresql.core.ConnectionFactory.openConnection;

public class Application {
    public static void main(String[] args) throws SQLException, LiquibaseException {
//        System.out.println("Введите название файла: ");
//        Scanner scanner = new Scanner(System.in);
//        String fileName = scanner.next();
//
//        System.out.println(fileName);

//// load properties from classpath
//        Connection conn = DriverManager.getConnection(System.getProperty("url"), System.getProperty("username"), System.getProperty("password"));
//        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(conn));
//        try (Liquibase liquibase = new liquibase.Liquibase("C:\\Users\\Ivan\\IdeaProjects\\Normalisation\\src\\main", new ClassLoaderResourceAccessor(), database)){
//            liquibase.update(new Contexts(), new LabelExpression());
//        }

        FilmRepository filmRepository = new FilmRepository();
        FilmopediaRepository filmopediaRepository = new FilmopediaRepository();
        Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ivan\\IdeaProjects\\Normalisation\\films.db");

        System.out.println(filmopediaRepository.fetchAll(connection));

    }
}
