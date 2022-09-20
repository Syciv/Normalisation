package ru.film.filmopedia;

import ru.film.filmopedia.repository.FilmRepository;
import ru.film.filmopedia.tables.pojos.Film;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws SQLException {
//        System.out.println("Введите название файла: ");
//        Scanner scanner = new Scanner(System.in);
//        String fileName = scanner.next();
//
//        System.out.println(fileName);

        FilmRepository filmRepository = new FilmRepository();

        List<Film> films = filmRepository.fetchList();

        System.out.println(films);

    }
}
