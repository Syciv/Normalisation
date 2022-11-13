package ru.film.filmopedia.entity;

import org.jooq.DSLContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.film.filmopedia.Tables;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.PersonRecord;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class PersonEntity extends FilmopediaEntity<PersonRecord> {

    public PersonEntity(Set<PersonRecord> set, DSLContext dslContext) {
        super(set, dslContext);
    }

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        PersonRecord person = new PersonRecord();
        person.setEntityId(Long.valueOf(filmopediaDto.getPersonEntityId()));
        person.setName(filmopediaDto.getPersonName());
        person.setSurname(filmopediaDto.getPersonSurname());
        person.setDateOfBirth(LocalDate.parse(filmopediaDto.getDateOfBirth(), dtf));
        person.setCountryId(Long.valueOf(filmopediaDto.getCountryEntityId()));
        set.add(person);
    }

    @Override
    @Transactional
    public void saveEntities() {
        dslContext.deleteFrom(Tables.PERSON)
                .where(Tables.PERSON.ENTITY_ID.in(set.stream().map(r ->
                        r.get(r.field("entity_id", Long.class))).toList()))
                .execute();
        insertEntities();
    }

}
