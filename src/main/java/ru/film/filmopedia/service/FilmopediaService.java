package ru.film.filmopedia.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.entity.*;

import java.sql.SQLException;
import java.util.List;

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

    public void saveEntities(FilmopediaDto filmopediaDto) throws SQLException {
        List<FilmopediaEntity<?>> filmopediaEntities = List.of(
                filmEntity,
                personEntity,
                newEntity,
                genreEntity,
                countryEntity,
                refFilmGenreEntity,
                refPersonFilmEntity);
        filmopediaEntities.forEach(entity -> entity.getRecordFromPojo(filmopediaDto));
        filmopediaEntities.forEach(FilmopediaEntity::saveEntities);
    }


}
