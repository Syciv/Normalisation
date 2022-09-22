package ru.film.filmopedia.repository;

import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import ru.film.filmopedia.dto.FilmopediaDto;

import java.sql.Connection;
import java.time.LocalDate;
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
                        obj.get(field(name("filmopedia", "id"), Long.class)),
                        obj.get(field(name("filmopedia", "filmEntityId"), Long.class)),
                        obj.get(field(name("filmopedia", "filmName"), String.class)),
                        obj.get(field(name("filmopedia", "filmDateOfRelease"), LocalDate.class)),
                        obj.get(field(name("filmopedia", "personEntityId"), Long.class)),
                        obj.get(field(name("filmopedia", "personName"), String.class)),
                        obj.get(field(name("filmopedia", "personSurname"), String.class)),
                        obj.get(field(name("filmopedia", "dateOfBirth"), LocalDate.class)),
                        obj.get(field(name("filmopedia", "countryEntityId"), Long.class)),
                        obj.get(field(name("filmopedia", "countryName"), String.class)),
                        obj.get(field(name("filmopedia", "personTypeEntityId"), Long.class)),
                        obj.get(field(name("filmopedia", "personTypeName"), String.class)),
                        obj.get(field(name("filmopedia", "genreEntityId"), Long.class)),
                        obj.get(field(name("filmopedia", "genreName"), String.class)),
                        obj.get(field(name("filmopedia", "newEntityId"), Long.class)),
                        obj.get(field(name("filmopedia", "newName"), String.class)),
                        obj.get(field(name("filmopedia", "newText"), String.class))
                        )
                )
                .collect(Collectors.toList());
    };

}
