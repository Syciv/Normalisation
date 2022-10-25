package ru.film.filmopedia.entity;

import org.jooq.DSLContext;
import org.springframework.stereotype.Component;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.RefFilmGenreRecord;

import java.util.Set;

@Component
public class RefFilmGenreEntity extends FilmopediaEntity<RefFilmGenreRecord> {

    public RefFilmGenreEntity(Set<RefFilmGenreRecord> map, DSLContext dslContext) {
        super(map, dslContext);
    }

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        RefFilmGenreRecord refFilmGenreRecord = new RefFilmGenreRecord();
        refFilmGenreRecord.setGenreId(Long.valueOf(filmopediaDto.getGenreEntityId()));
        refFilmGenreRecord.setFilmId(Long.valueOf(filmopediaDto.getFilmEntityId()));
        map.add(refFilmGenreRecord);
    }

}
