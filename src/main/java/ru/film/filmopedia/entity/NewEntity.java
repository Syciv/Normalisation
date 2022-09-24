package ru.film.filmopedia.entity;

import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.NewRecord;

public class NewEntity extends FilmopediaEntity<NewRecord> {

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        NewRecord neww = new NewRecord();
        neww.setEntityId(Long.valueOf(filmopediaDto.getNewEntityId()));
        neww.setName(filmopediaDto.getNewName());
        neww.setText(filmopediaDto.getNewText());
        neww.setFilmId(Long.valueOf(filmopediaDto.getFilmEntityId()));
        map.add(neww);
    }
}

