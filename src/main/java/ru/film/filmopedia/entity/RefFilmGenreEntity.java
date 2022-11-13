package ru.film.filmopedia.entity;

import org.jooq.DSLContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.film.filmopedia.Tables;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.RefFilmGenreRecord;

import java.util.Set;

@Component
public class RefFilmGenreEntity extends FilmopediaEntity<RefFilmGenreRecord> {

    public RefFilmGenreEntity(Set<RefFilmGenreRecord> set, DSLContext dslContext) {
        super(set, dslContext);
    }

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        RefFilmGenreRecord refFilmGenreRecord = new RefFilmGenreRecord();
        refFilmGenreRecord.setGenreId(Long.valueOf(filmopediaDto.getGenreEntityId()));
        refFilmGenreRecord.setFilmId(Long.valueOf(filmopediaDto.getFilmEntityId()));
        set.add(refFilmGenreRecord);
    }

    @Override
    @Transactional
    public void saveEntities() {
        dslContext.deleteFrom(Tables.REF_FILM_GENRE)
                .where(Tables.REF_FILM_GENRE.FILM_ID.in(set.stream().map(r -> r.get(r.field("film_id", Long.class))).toList())
                        .and(Tables.REF_FILM_GENRE.GENRE_ID.in(set.stream().map(r -> r.get(r.field("genre_id", Long.class))).toList())))
                .execute();
        insertEntities();
    }

}
