package ru.film.filmopedia.entity;

import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.RefFilmGenreRecord;

public class RefFilmGenreEntity extends FilmopediaEntity<RefFilmGenreRecord> {

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        RefFilmGenreRecord refPersonFilmRecord = new RefFilmGenreRecord();
        refPersonFilmRecord.setGenreId(Long.valueOf(filmopediaDto.getGenreEntityId()));
        refPersonFilmRecord.setFilmId(Long.valueOf(filmopediaDto.getFilmEntityId()));
        map.add(refPersonFilmRecord);
    }

}
