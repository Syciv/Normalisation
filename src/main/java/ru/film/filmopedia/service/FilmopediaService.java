package ru.film.filmopedia.service;
import org.apache.commons.lang3.tuple.Triple;
import org.apache.commons.math3.util.Pair;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.entity.*;
import ru.film.filmopedia.repository.FilmopediaRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.*;

public class FilmopediaService {

    private final List<FilmopediaEntity<?>> filmopediaEntities = List.of(
            new FilmEntity(),
            new PersonEntity(),
            new NewEntity(),
            new GenreEntity(),
            new CountryEntity(),
            new RefFilmGenreEntity(),
            new RefPersonFilmEntity());

    public void saveEntities(Connection connection) throws SQLException {
        FilmopediaRepository filmopediaRepository = new FilmopediaRepository();

        List<FilmopediaDto> filmopediaDtos = filmopediaRepository.fetchAll(connection);

        for(FilmopediaDto filmopediaDto: filmopediaDtos) {
            filmopediaEntities.forEach(entity -> entity.getRecordFromPojo(filmopediaDto));
        }

        Connection pgConnection = DriverManager.getConnection(System.getProperty("url"), System.getProperty("username"), System.getProperty("password"));
        filmopediaEntities.forEach(entity -> entity.saveEntities(pgConnection));
    }
    
}
