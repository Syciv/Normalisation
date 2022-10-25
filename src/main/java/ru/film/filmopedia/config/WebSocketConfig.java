package ru.film.filmopedia.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import ru.film.filmopedia.handler.WebSocketFilmsHandler;
import ru.film.filmopedia.service.FilmopediaService;

@Configuration
@EnableWebSocket
@AllArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

    private final FilmopediaService filmopediaService;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketFilmHandler(filmopediaService), "/films");
    }

    @Bean
    public WebSocketHandler webSocketFilmHandler(FilmopediaService filmopediaService) {
        return new WebSocketFilmsHandler(filmopediaService);
    }
}


