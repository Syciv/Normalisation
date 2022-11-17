package ru.film.filmopedia.controller;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.film.filmopedia.dto.FilmMessageDto;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.service.FilmopediaService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/films")
public class FilmopediaRestController {

    private final FilmopediaService filmopediaService;

    @SneakyThrows
    @PostMapping
    public void save(@RequestBody FilmopediaDto filmMessageDto){
        System.out.println(filmMessageDto);
        filmopediaService.saveEntities(filmMessageDto);
    }

}
