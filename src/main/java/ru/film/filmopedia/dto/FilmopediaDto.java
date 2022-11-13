package ru.film.filmopedia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FilmopediaDto {
    private Integer id;
    private Integer filmEntityId;
    private String filmName;
    private String filmDateOfRelease;
    private Integer personEntityId;
    private String personName;
    private String personSurname;
    private String dateOfBirth;
    private Integer countryEntityId;
    private String countryName;
    private Integer personTypeEntityId;
    private String personTypeName;
    private Integer genreEntityId;
    private String genreName;
    private Integer newEntityId;
    private String newName;
    private String newText;
}
