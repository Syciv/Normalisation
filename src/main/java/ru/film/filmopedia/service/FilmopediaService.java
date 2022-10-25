package ru.film.filmopedia.service;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.Triple;
import org.apache.commons.math3.util.Pair;
import org.springframework.stereotype.Service;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.entity.*;
import ru.film.filmopedia.repository.FilmopediaRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.*;

@AllArgsConstructor
@Service
public class FilmopediaService {

    private final FilmEntity filmEntity;

    private final PersonEntity personEntity;

    private final NewEntity newEntity;

    private final GenreEntity genreEntity;

    private final CountryEntity countryEntity;

    private final RefFilmGenreEntity refFilmGenreEntity;

    private final RefPersonFilmEntity refPersonFilmEntity;


    public void saveEntities(Connection connection) throws SQLException {
        FilmopediaRepository filmopediaRepository = new FilmopediaRepository();

        List<FilmopediaEntity<?>> filmopediaEntities = List.of(
                filmEntity,
                personEntity,
                newEntity,
                genreEntity,
                countryEntity,
                refFilmGenreEntity,
                refPersonFilmEntity);
        List<FilmopediaDto> filmopediaDtos = filmopediaRepository.fetchAll(connection);

        for (FilmopediaDto filmopediaDto : filmopediaDtos) {
            filmopediaEntities.forEach(entity -> entity.getRecordFromPojo(filmopediaDto));
        }

        Connection pgConnection = DriverManager.getConnection(System.getProperty("url"), System.getProperty("username"), System.getProperty("password"));
        filmopediaEntities.forEach(FilmopediaEntity::saveEntities);
    }

    public void saveEntities(List<FilmopediaDto> filmopediaDtos) throws SQLException {
        List<FilmopediaEntity<?>> filmopediaEntities = List.of(
                filmEntity,
                personEntity,
                newEntity,
                genreEntity,
                countryEntity,
                refFilmGenreEntity,
                refPersonFilmEntity);
        for (FilmopediaDto filmopediaDto : filmopediaDtos) {
            filmopediaEntities.forEach(entity -> entity.getRecordFromPojo(filmopediaDto));
        }

        filmopediaEntities.forEach(FilmopediaEntity::saveEntities);
    }

}
