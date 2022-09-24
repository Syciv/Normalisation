package ru.film.filmopedia;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.jooq.meta.derby.sys.Sys;
import ru.film.filmopedia.repository.FilmRepository;
import ru.film.filmopedia.repository.FilmopediaRepository;
import ru.film.filmopedia.service.FilmopediaService;
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

        System.out.println("Введите путь к файлу SQLite:");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();

        Connection sqliteConnection = DriverManager.getConnection("jdbc:sqlite:" + fileName);
        FilmopediaService filmopediaService = new FilmopediaService();
        filmopediaService.saveEntities(sqliteConnection);
        System.out.println("В БД успешно добавлены новые записи из SQLite");
    }
}
