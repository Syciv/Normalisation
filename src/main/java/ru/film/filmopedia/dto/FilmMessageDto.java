package ru.film.filmopedia.dto;

import lombok.Data;

import java.util.List;

@Data
public class FilmMessageDto {
    private List<FilmopediaDto> filmopediaDtos;
}
