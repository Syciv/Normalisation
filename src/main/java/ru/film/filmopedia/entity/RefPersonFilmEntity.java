package ru.film.filmopedia.entity;

import org.jooq.DSLContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.film.filmopedia.Tables;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.RefPersonFilmRecord;

import java.util.Set;

@Component
public class RefPersonFilmEntity extends FilmopediaEntity<RefPersonFilmRecord> {

    public RefPersonFilmEntity(Set<RefPersonFilmRecord> set, DSLContext dslContext) {
        super(set, dslContext);
    }

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        RefPersonFilmRecord refPersonFilmRecord = new RefPersonFilmRecord();
        refPersonFilmRecord.setPersonId(Long.valueOf(filmopediaDto.getPersonEntityId()));
        refPersonFilmRecord.setFilmId(Long.valueOf(filmopediaDto.getFilmEntityId()));
        refPersonFilmRecord.setPersonTypeId(Long.valueOf(filmopediaDto.getPersonTypeEntityId()));
        set.add(refPersonFilmRecord);
    }

    @Override
    @Transactional
    public void saveEntities() {
        dslContext.deleteFrom(Tables.REF_PERSON_FILM)
                .where(Tables.REF_PERSON_FILM.PERSON_ID.in(set.stream().map(r -> r.get(r.field("person_id", Long.class))).toList())
                        .and(Tables.REF_PERSON_FILM.FILM_ID.in(set.stream().map(r -> r.get(r.field("film_id", Long.class))).toList())))
                .execute();
        insertEntities();
    }
}
