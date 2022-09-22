package ru.film.filmopedia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class FilmopediaDto {
    private Long id;
    private Long filmEntityId;
    private String filmName;
    private LocalDate filmDateOfRelease;
    private Long personEntityId;
    private String personName;
    private String personSurname;
    private LocalDate dateOfBirth;
    private Long countryEntityId;
    private String countryName;
    private Long personTypeEntityId;
    private String personTypeName;
    private Long genreEntityId;
    private String genreName;
    private Long newEntityId;
    private String newName;
    private String newText;
}
