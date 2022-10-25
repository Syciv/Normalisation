package ru.film.filmopedia.entity;

import org.jooq.DSLContext;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.RefFilmGenreRecord;

import java.util.Set;

public class RefFilmGenreEntity extends FilmopediaEntity<RefFilmGenreRecord> {

    public RefFilmGenreEntity(Set<RefFilmGenreRecord> map, DSLContext dslContext) {
        super(map, dslContext);
    }

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        RefFilmGenreRecord refPersonFilmRecord = new RefFilmGenreRecord();
        refPersonFilmRecord.setGenreId(Long.valueOf(filmopediaDto.getGenreEntityId()));
        refPersonFilmRecord.setFilmId(Long.valueOf(filmopediaDto.getFilmEntityId()));
        map.add(refPersonFilmRecord);
    }

}
