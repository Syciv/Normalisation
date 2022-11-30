package ru.film.filmopedia.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.film.filmopedia.springsoap.gen.Filmopedia;
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

    public void saveEntities(List<FilmopediaDto> filmopediaDtos) {
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

    public void saveEntities(FilmopediaDto filmopediaDto) {
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

    public void saveEntities(Filmopedia filmopedia) {
        saveEntities(convertToFilmopediaDto(filmopedia));
    }

    public FilmopediaDto convertToFilmopediaDto(Filmopedia filmopedia){
        FilmopediaDto filmopediaDto = new FilmopediaDto();
        filmopediaDto.setId(filmopedia.getId());
        filmopediaDto.setFilmEntityId(filmopedia.getFilmEntityId());
        filmopediaDto.setFilmName(filmopedia.getFilmName());
        filmopediaDto.setFilmDateOfRelease(filmopedia.getFilmDateOfRelease());
        filmopediaDto.setPersonEntityId(filmopedia.getPersonEntityId());
        filmopediaDto.setPersonName(filmopedia.getPersonName());
        filmopediaDto.setPersonSurname(filmopedia.getPersonSurname());
        filmopediaDto.setDateOfBirth(filmopedia.getDateOfBirth());
        filmopediaDto.setCountryEntityId(filmopedia.getCountryEntityId());
        filmopediaDto.setCountryName(filmopedia.getCountryName());
        filmopediaDto.setPersonTypeEntityId(filmopedia.getPersonTypeEntityId());
        filmopediaDto.setPersonTypeName(filmopedia.getPersonTypeName());
        filmopediaDto.setGenreEntityId(filmopedia.getGenreEntityId());
        filmopediaDto.setGenreName(filmopedia.getGenreName());
        filmopediaDto.setNewEntityId(filmopedia.getNewEntityId());
        filmopediaDto.setNewName(filmopedia.getNewName());
        filmopediaDto.setNewText(filmopedia.getNewText());

        return filmopediaDto;
    }


}
