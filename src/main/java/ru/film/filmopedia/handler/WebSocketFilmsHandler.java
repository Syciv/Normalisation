package ru.film.filmopedia.handler;


import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jooq.meta.derby.sys.Sys;
import org.jooq.meta.derby.sys.tables.Sysschemas;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.film.filmopedia.dto.FilmMessageDto;
import ru.film.filmopedia.dto.FilmopediaDto;
import ru.film.filmopedia.service.FilmopediaService;

import java.sql.SQLException;

@AllArgsConstructor
public class WebSocketFilmsHandler extends TextWebSocketHandler {

    private final FilmopediaService filmopediaService;

    @Override
    public void handleTextMessage(@NotNull WebSocketSession session, TextMessage message) throws SQLException {
//        System.out.println("=============");
//        System.out.println(message.getPayload());
        FilmopediaDto filmopediaDto = new Gson().fromJson(message.getPayload(), FilmopediaDto.class);
        filmopediaService.saveEntities(filmopediaDto);
    }

}
