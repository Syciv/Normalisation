package ru.film.filmopedia.repository;

import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.tables.pojos.Country;
import ru.film.filmopedia.tables.pojos.Film;
import ru.film.filmopedia.tables.pojos.New;
import ru.film.filmopedia.tables.pojos.Person;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static org.jooq.impl.DSL.*;

public class FilmopediaRepository {
    public List<FilmopediaDto> fetchAll(Connection connection) {
        return DSL.using(connection, SQLDialect.SQLITE)
                .selectFrom(table("filmopedia"))
                .fetch()
                .stream()
                .map(obj -> new FilmopediaDto(
                                obj.get(field(name("filmopedia", "id"), Integer.class)),
                                obj.get(field(name("filmopedia", "film_entity_id"), Integer.class)),
                                obj.get(field(name("filmopedia", "film_name"), String.class)),
                                obj.get(field(name("filmopedia", "film_date_of_release"), String.class)),
                                obj.get(field(name("filmopedia", "person_entity_id"), Integer.class)),
                                obj.get(field(name("filmopedia", "person_name"), String.class)),
                                obj.get(field(name("filmopedia", "person_surname"), String.class)),
                                obj.get(field(name("filmopedia", "date_of_birth"), String.class)),
                                obj.get(field(name("filmopedia", "country_entity_id"), Integer.class)),
                                obj.get(field(name("filmopedia", "country_name"), String.class)),
                                obj.get(field(name("filmopedia", "person_type_entity_id"), Integer.class)),
                                obj.get(field(name("filmopedia", "person_type_name"), String.class)),
                                obj.get(field(name("filmopedia", "genre_entity_id"), Integer.class)),
                                obj.get(field(name("filmopedia", "genre_name"), String.class)),
                                obj.get(field(name("filmopedia", "new_entity_id"), Integer.class)),
                                obj.get(field(name("filmopedia", "new_name"), String.class)),
                                obj.get(field(name("filmopedia", "new_text"), String.class))
                        )
                )
                .collect(Collectors.toList());
    }

}
