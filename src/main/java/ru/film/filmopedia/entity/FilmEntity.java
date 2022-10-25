package ru.film.filmopedia.entity;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.FilmRecord;

import java.time.LocalDate;
import java.util.Set;

@Service
public class FilmEntity extends FilmopediaEntity<FilmRecord> {

    public FilmEntity(Set<FilmRecord> map, DSLContext dslContext) {
        super(map, dslContext);
    }

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        FilmRecord film = new FilmRecord();
        film.setEntityId(Long.valueOf(filmopediaDto.getFilmEntityId()));
        film.setName(filmopediaDto.getFilmName());
        film.setDateOfRelease(LocalDate.parse(filmopediaDto.getFilmDateOfRelease(), dtf));
        map.add(film);
    }
}


