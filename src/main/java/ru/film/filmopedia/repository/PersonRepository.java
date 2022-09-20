package ru.film.filmopedia.repository;

import org.jooq.impl.DSL;
import ru.film.filmopedia.Tables;
import ru.film.filmopedia.tables.pojos.Person;

import java.sql.Connection;
import java.util.List;

import static ru.film.filmopedia.Tables.PERSON;

public class PersonRepository {
    
    public List<Person> getList(Connection connection){
        return DSL.using(connection)
                .selectFrom(PERSON)
                .fetchInto(Person.class);
    }

    public void create(Connection connection, Person person){
        DSL.using(connection)
                .insertInto(PERSON)
                .set(PERSON.NAME, person.getName())
                .set(PERSON.SURNAME, person.getSurname())
                .set(PERSON.DATE_OF_BIRTH, person.getDateOfBirth())
                .set(PERSON.COUNTRY_ID, person.getCountryId())
                .execute();
    }
    
}
