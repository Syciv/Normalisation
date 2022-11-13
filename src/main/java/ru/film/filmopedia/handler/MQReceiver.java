package ru.film.filmopedia.handler;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.film.filmopedia.dto.FilmMessageDto;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.service.FilmopediaService;

@Component
@AllArgsConstructor
public class MQReceiver {

    private final FilmopediaService filmopediaService;

    @SneakyThrows
    @RabbitListener(queues = "films")
    public void receive(String message){
        System.out.println(message);
        FilmopediaDto filmopediaDto = new Gson().fromJson(message, FilmopediaDto.class);
        filmopediaService.saveEntities(filmopediaDto);
    }

}
