package ru.film.filmopedia.data;

import lombok.Data;
import ru.film.filmopedia.dto.FilmopediaDto;

import java.util.List;

@Data
public class FilmMessageDto {
    private List<FilmopediaDto> filmopediaDtos;
}
