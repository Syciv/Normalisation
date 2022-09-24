package ru.film.filmopedia.entity;

import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.CountryRecord;
import ru.film.filmopedia.tables.records.FilmRecord;

import java.time.LocalDate;

public class CountryEntity extends FilmopediaEntity<CountryRecord> {

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        CountryRecord countryRecord = new CountryRecord();
        countryRecord.setEntityId(Long.valueOf(filmopediaDto.getCountryEntityId()));
        countryRecord.setName(filmopediaDto.getCountryName());
        map.add(countryRecord);
    }
}


