package ru.film.filmopedia.entity;

import org.jooq.SQLDialect;
import org.jooq.TableRecord;
import org.jooq.impl.DSL;
import ru.film.filmopedia.dto.FilmopediaDto;

import java.sql.Connection;
import java.time.format.DateTimeFormatter;
import java.util.*;

public abstract class FilmopediaEntity <T extends TableRecord<?>> {

    protected Set<T> map = new TreeSet<>();
    protected final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public abstract void getRecordFromPojo(FilmopediaDto filmopediaDto);

    public void saveEntities(Connection connection){
        DSL.using(connection, SQLDialect.POSTGRES).batchInsert(this.map).execute();
    };

}
