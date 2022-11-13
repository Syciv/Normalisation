package ru.film.filmopedia.entity;

import org.jooq.DSLContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.film.filmopedia.Tables;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.CountryRecord;

import java.util.Set;

@Component
public class CountryEntity extends FilmopediaEntity<CountryRecord> {

    public CountryEntity(Set<CountryRecord> set, DSLContext dslContext) {
        super(set, dslContext);
    }

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        CountryRecord countryRecord = new CountryRecord();
        countryRecord.setEntityId(Long.valueOf(filmopediaDto.getCountryEntityId()));
        countryRecord.setName(filmopediaDto.getCountryName());
        set.add(countryRecord);
    }

    @Override
    @Transactional
    public void saveEntities() {
        dslContext.deleteFrom(Tables.COUNTRY)
                .where(Tables.COUNTRY.ENTITY_ID.in(set.stream().map(r ->
                        r.get(r.field("entity_id", Long.class))).toList()))
                .execute();
        insertEntities();
    }
}


