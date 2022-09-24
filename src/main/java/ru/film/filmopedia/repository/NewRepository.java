package ru.film.filmopedia.repository;

import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import ru.film.filmopedia.tables.pojos.New;

import java.sql.Connection;
import java.util.List;

import static ru.film.filmopedia.Tables.NEW;

public class NewRepository {

    public List<New> fetchList(Connection connection){
        return  DSL.using(connection, SQLDialect.POSTGRES)
                .selectFrom(NEW)
                .fetchInto(New.class);
    }

    public void create(Connection connection, New neww){
        DSL.using(connection, SQLDialect.POSTGRES)
                .insertInto(NEW)
                .set(NEW.ENTITY_ID, neww.getEntityId())
                .set(NEW.NAME, neww.getName())
                .set(NEW.TEXT, neww.getText())
                .execute();
    }

}
