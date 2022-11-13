package ru.film.filmopedia.entity;

import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.TableRecord;
import ru.film.filmopedia.dto.FilmopediaDto;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public abstract class FilmopediaEntity <T extends TableRecord<?>> {

    protected Set<T> set;
    protected final DSLContext dslContext;
    protected final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public abstract void getRecordFromPojo(FilmopediaDto filmopediaDto);

    public abstract void saveEntities();

    protected void insertEntities(){
        dslContext.batchInsert(set).execute();
        set = new HashSet<>();
    };

}
