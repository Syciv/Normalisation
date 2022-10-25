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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.film.filmopedia.repository.FilmRepository;
import ru.film.filmopedia.repository.FilmopediaRepository;
import ru.film.filmopedia.service.FilmopediaService;
import ru.film.filmopedia.tables.pojos.Film;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

import static org.postgresql.core.ConnectionFactory.openConnection;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws SQLException, LiquibaseException, IOException, InterruptedException {
        SpringApplication.run(Application.class);
        System.out.println("Введите путь к файлу SQLite:");
//        Scanner scanner = new Scanner(System.in);
//        String fileName =  "films.db" ;// scanner.next();

//        Connection sqliteConnection = DriverManager.getConnection("jdbc:sqlite:" + fileName);
//        FilmopediaService filmopediaService = new FilmopediaService();
//        filmopediaService.saveEntities(sqliteConnection);
//        System.out.println("В БД успешно добавлены новые записи из SQLite");
//
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("http://127.0.0.1:5000/"))
//                .build();
//
//        HttpResponse<String> response = client.send(request,
//                HttpResponse.BodyHandlers.ofString());
//
//        System.out.println(response.body());
//        System.out.println("Экспорт прошёл успешно");

    }
}
