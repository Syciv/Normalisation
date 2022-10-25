package ru.film.filmopedia.entity;

import org.jooq.DSLContext;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.PersonRecord;

import java.time.LocalDate;
import java.util.Set;

public class PersonEntity extends FilmopediaEntity<PersonRecord> {

    public PersonEntity(Set<PersonRecord> map, DSLContext dslContext) {
        super(map, dslContext);
    }

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        PersonRecord person = new PersonRecord();
        person.setEntityId(Long.valueOf(filmopediaDto.getPersonEntityId()));
        person.setName(filmopediaDto.getPersonName());
        person.setSurname(filmopediaDto.getPersonSurname());
        person.setDateOfBirth(LocalDate.parse(filmopediaDto.getDateOfBirth(), dtf));
        person.setCountryId(Long.valueOf(filmopediaDto.getCountryEntityId()));
        map.add(person);
    }

}
