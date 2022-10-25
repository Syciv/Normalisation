package ru.film.filmopedia.entity;

import org.jooq.DSLContext;
import org.springframework.stereotype.Component;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.RefPersonFilmRecord;

import java.util.Set;

@Component
public class RefPersonFilmEntity extends FilmopediaEntity<RefPersonFilmRecord> {

    public RefPersonFilmEntity(Set<RefPersonFilmRecord> map, DSLContext dslContext) {
        super(map, dslContext);
    }

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        RefPersonFilmRecord refPersonFilmRecord = new RefPersonFilmRecord();
        refPersonFilmRecord.setPersonId(Long.valueOf(filmopediaDto.getPersonEntityId()));
        refPersonFilmRecord.setFilmId(Long.valueOf(filmopediaDto.getFilmEntityId()));
        refPersonFilmRecord.setPersonTypeId(Long.valueOf(filmopediaDto.getPersonTypeEntityId()));
        map.add(refPersonFilmRecord);
    }

}
