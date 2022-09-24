package ru.film.filmopedia.entity;

import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.PersonRecord;

import java.time.LocalDate;

public class PersonEntity extends FilmopediaEntity<PersonRecord> {

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
