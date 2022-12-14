--liquibase formatted sql

--changeset ivan_sych:1
CREATE SCHEMA IF NOT EXISTS filmopedia;

--changeset ivan_sych:2
CREATE TABLE filmopedia.film
(
    id              bigserial PRIMARY KEY,
    entity_id       bigint,
    name            text,
    date_of_release date,
    description     text
);

--changeset ivan_sych:3
CREATE TABLE filmopedia.country
(
    id        bigserial PRIMARY KEY,
    entity_id bigint,
    name      text
);

--changeset ivan_sych:4
CREATE TABLE filmopedia.person
(
    id            bigserial PRIMARY KEY,
    entity_id     bigint,
    name          text,
    surname       text,
    date_of_birth date,
    country_id    bigint
);


--changeset ivan_sych:5
CREATE TABLE filmopedia.new
(
    id        bigserial PRIMARY KEY,
    entity_id bigint,
    name      text,
    text      text,
    film_id   bigint
);

--changeset ivan_sych:6
CREATE TABLE filmopedia.genre
(
    id        bigserial PRIMARY KEY,
    entity_id bigint,
    name      text
);

--changeset ivan_sych:7
CREATE TABLE filmopedia.person_type
(
    id        bigserial PRIMARY KEY,
    entity_id bigint,
    name      text
);

--changeset ivan_sych:9
CREATE TABLE filmopedia.ref_person_film
(
    id        bigserial PRIMARY KEY,
    person_id bigint,
    film_id bigint,
    person_type_id bigint
);

--changeset ivan_sych:10
CREATE TABLE filmopedia.ref_film_genre
(
    id       bigserial PRIMARY KEY,
    film_id  bigint,
    genre_id bigint
);

--changeset ivan_sych:11
ALTER TABLE filmopedia.film ADD COLUMN datetime_of_delete timestamp;
ALTER TABLE filmopedia.country ADD COLUMN datetime_of_delete timestamp;
ALTER TABLE filmopedia.person ADD COLUMN datetime_of_delete timestamp;
ALTER TABLE filmopedia.new ADD COLUMN datetime_of_delete timestamp;
ALTER TABLE filmopedia.genre ADD COLUMN datetime_of_delete timestamp;
ALTER TABLE filmopedia.person_type ADD COLUMN datetime_of_delete timestamp;
ALTER TABLE filmopedia.ref_person_film ADD COLUMN datetime_of_delete timestamp;
ALTER TABLE filmopedia.ref_film_genre ADD COLUMN datetime_of_delete timestamp;


