package ru.film.filmopedia.repository;

import lombok.Value;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.postgresql.jdbc.PgConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import ru.film.filmopedia.Tables;
import ru.film.filmopedia.tables.pojos.Film;
import ru.film.filmopedia.tables.pojos.Person;

import static ru.film.filmopedia.Tables.FILM;

public class FilmRepository {

    Connection conn = DriverManager.getConnection(System.getProperty("url"), System.getProperty("username"), System.getProperty("password"));
    private final DSLContext dslContext = DSL.using(conn, SQLDialect.POSTGRES);

    public FilmRepository() throws SQLException {
    }

    public List<Film> fetchList(Connection connection){
        return  DSL.using(connection, SQLDialect.POSTGRES)
                .selectFrom(FILM)
                .fetchInto(Film.class);
    }

    public void create(Connection connection, Film film){
        DSL.using(connection, SQLDialect.POSTGRES)
                .insertInto(FILM)
                .set(FILM.ENTITY_ID, film.getEntityId())
                .set(FILM.NAME, film.getName())
                .set(FILM.DATE_OF_RELEASE, film.getDateOfRelease())
                .execute();
    }
}
