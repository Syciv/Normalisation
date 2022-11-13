package ru.film.filmopedia.entity;

import org.jooq.DSLContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.film.filmopedia.Tables;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.FilmRecord;

import java.time.LocalDate;
import java.util.Set;

@Component
public class FilmEntity extends FilmopediaEntity<FilmRecord> {

    public FilmEntity(Set<FilmRecord> set, DSLContext dslContext) {
        super(set, dslContext);
    }

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        FilmRecord film = new FilmRecord();
        film.setEntityId(Long.valueOf(filmopediaDto.getFilmEntityId()));
        film.setName(filmopediaDto.getFilmName());
        film.setDateOfRelease(LocalDate.parse(filmopediaDto.getFilmDateOfRelease(), dtf));
        set.add(film);
    }

    @Override
    @Transactional
    public void saveEntities() {
        dslContext.deleteFrom(Tables.FILM)
                .where(Tables.FILM.ENTITY_ID.in(set.stream().map(r ->
                        r.get(r.field("entity_id", Long.class))).toList()))
                .execute();
        insertEntities();
    }
}


