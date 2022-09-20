
--changeset ivan_sych:1
CREATE SCHEMA IF NOT EXISTS filmopedia;

--changeset ivan_sych:2
CREATE TABLE filmopedia.film(
    id bigserial PRIMARY KEY,
    name text,
    date_of_release date,
    description text
);

--changeset ivan_sych:3
CREATE TABLE filmopedia.country(
    id bigserial PRIMARY KEY,
    name text
);

--changeset ivan_sych:4
CREATE TABLE filmopedia.person(
    id bigserial PRIMARY KEY,
    name text,
    surname text,
    date_of_birth date,
    country_id bigint REFERENCES country(id)
);


--changeset ivan_sych:5
CREATE TABLE filmopedia.new(
    id bigserial PRIMARY KEY,
    name text,
    text_text,
    film_id bigint REFERENCES film(id)
);

--changeset ivan_sych:6
CREATE TABLE filmopedia.genre(
    id bigserial PRIMARY KEY,
    name text
);

--changeset ivan_sych:7
CREATE TABLE filmopedia.person_type(
    id bigserial PRIMARY KEY,
    name text
);

--changeset ivan_sych:9
CREATE TABLE filmopedia.ref_person_film(
    id bigserial PRIMARY KEY,
    person_id bigint REFERENCES person(id),
    film_id bigint REFERENCES film(id),
    person_type_id bigint REFERENCES person_type(id)
);

--changeset ivan_sych:10
CREATE TABLE filmopedia.ref_film_genre(
    id bigserial PRIMARY KEY,
    film_id bigint,
    genre_id bigint
);



