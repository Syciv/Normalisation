package ru.film.filmopedia.entity;

import org.jooq.DSLContext;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.CountryRecord;
import ru.film.filmopedia.tables.records.FilmRecord;

import java.time.LocalDate;
import java.util.Set;

public class CountryEntity extends FilmopediaEntity<CountryRecord> {

    public CountryEntity(Set<CountryRecord> map, DSLContext dslContext) {
        super(map, dslContext);
    }

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        CountryRecord countryRecord = new CountryRecord();
        countryRecord.setEntityId(Long.valueOf(filmopediaDto.getCountryEntityId()));
        countryRecord.setName(filmopediaDto.getCountryName());
        map.add(countryRecord);
    }
}


