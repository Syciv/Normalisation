package ru.film.filmopedia.entity;

import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.TableRecord;
import org.springframework.stereotype.Service;
import ru.film.filmopedia.dto.FilmopediaDto;

import java.time.format.DateTimeFormatter;
import java.util.*;

@AllArgsConstructor
public abstract class FilmopediaEntity <T extends TableRecord<?>> {

    protected Set<T> map = new TreeSet<>();

    protected final DSLContext dslContext;
    protected final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public abstract void getRecordFromPojo(FilmopediaDto filmopediaDto);

    public void saveEntities(){
        dslContext.batchInsert(this.map).execute();
    };

}
