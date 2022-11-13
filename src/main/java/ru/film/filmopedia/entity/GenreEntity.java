package ru.film.filmopedia.entity;

import org.jooq.DSLContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.film.filmopedia.Tables;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.GenreRecord;

import java.util.Set;

@Component
public class GenreEntity extends FilmopediaEntity<GenreRecord> {

    public GenreEntity(Set<GenreRecord> set, DSLContext dslContext) {
        super(set, dslContext);
    }

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        GenreRecord genreRecord = new GenreRecord();
        genreRecord.setEntityId(Long.valueOf(filmopediaDto.getGenreEntityId()));
        genreRecord.setName(filmopediaDto.getGenreName());
        set.add(genreRecord);
    }

    @Override
    @Transactional
    public void saveEntities() {
        dslContext.deleteFrom(Tables.GENRE)
                .where(Tables.GENRE.ENTITY_ID.in(set.stream().map(r ->
                        r.get(r.field("entity_id", Long.class))).toList()))
                .execute();
        insertEntities();
    }
}
