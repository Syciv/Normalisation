package ru.film.filmopedia.entity;

import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.GenreRecord;

public class GenreEntity extends FilmopediaEntity<GenreRecord> {

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        GenreRecord genreRecord = new GenreRecord();
        genreRecord.setEntityId(Long.valueOf(filmopediaDto.getGenreEntityId()));
        genreRecord.setName(filmopediaDto.getGenreName());
        map.add(genreRecord);
    }
}
