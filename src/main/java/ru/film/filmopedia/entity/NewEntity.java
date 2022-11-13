package ru.film.filmopedia.entity;

import org.jooq.DSLContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.film.filmopedia.Tables;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.records.NewRecord;

import java.util.Set;

@Component
public class NewEntity extends FilmopediaEntity<NewRecord> {

    public NewEntity(Set<NewRecord> set, DSLContext dslContext) {
        super(set, dslContext);
    }

    public void getRecordFromPojo(FilmopediaDto filmopediaDto) {
        NewRecord neww = new NewRecord();
        neww.setEntityId(Long.valueOf(filmopediaDto.getNewEntityId()));
        neww.setName(filmopediaDto.getNewName());
        neww.setText(filmopediaDto.getNewText());
        neww.setFilmId(Long.valueOf(filmopediaDto.getFilmEntityId()));
        set.add(neww);
    }

    @Override
    @Transactional
    public void saveEntities() {
        dslContext.deleteFrom(Tables.NEW)
                .where(Tables.NEW.ENTITY_ID.in(set.stream().map(r ->
                        r.get(r.field("entity_id", Long.class))).toList()))
                .execute();
        insertEntities();
    }
}

