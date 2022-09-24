package ru.film.filmopedia.entity;

import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.FilmRecord;

import java.time.LocalDate;

public class FilmEntity extends FilmopediaEntity<FilmRecord> {

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        FilmRecord film = new FilmRecord();
        film.setEntityId(Long.valueOf(filmopediaDto.getFilmEntityId()));
        film.setName(filmopediaDto.getFilmName());
        film.setDateOfRelease(LocalDate.parse(filmopediaDto.getFilmDateOfRelease(), dtf));
        map.add(film);
    }
}


