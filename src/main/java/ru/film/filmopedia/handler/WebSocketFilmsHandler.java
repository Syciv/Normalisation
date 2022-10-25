package ru.film.filmopedia.handler;


import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.film.filmopedia.data.FilmMessageDto;
import ru.film.filmopedia.service.FilmopediaService;

import java.sql.SQLException;

@AllArgsConstructor
public class WebSocketFilmsHandler extends TextWebSocketHandler {

    private final FilmopediaService filmopediaService;

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws SQLException {
        FilmMessageDto filmMessageDto = new Gson().fromJson(message.getPayload(), FilmMessageDto.class);
        System.out.println(filmMessageDto.getFilmopediaDtos());
        filmopediaService.saveEntities(filmMessageDto.getFilmopediaDtos());
    }

}
