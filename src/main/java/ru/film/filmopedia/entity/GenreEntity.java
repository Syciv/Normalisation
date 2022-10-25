package ru.film.filmopedia.entity;

import org.jooq.DSLContext;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.GenreRecord;

import java.util.Set;

public class GenreEntity extends FilmopediaEntity<GenreRecord> {

    public GenreEntity(Set<GenreRecord> map, DSLContext dslContext) {
        super(map, dslContext);
    }

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        GenreRecord genreRecord = new GenreRecord();
        genreRecord.setEntityId(Long.valueOf(filmopediaDto.getGenreEntityId()));
        genreRecord.setName(filmopediaDto.getGenreName());
        map.add(genreRecord);
    }
}
