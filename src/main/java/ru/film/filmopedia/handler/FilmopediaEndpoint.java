package ru.film.filmopedia.handler;

import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.film.filmopedia.service.FilmopediaService;
import ru.film.filmopedia.springsoap.gen.FilmopediaRequest;
import ru.film.filmopedia.springsoap.gen.FilmopediaResponse;

@Endpoint
@AllArgsConstructor
public class FilmopediaEndpoint {

    private static final String NAMESPACE_URI = "http://filmopedia.film.ru/springsoap/gen";

    private final FilmopediaService filmopediaService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "filmopediaRequest")
    @ResponsePayload
    public FilmopediaResponse filmopediaRequest(@RequestPayload FilmopediaRequest request) {
        FilmopediaResponse response = new FilmopediaResponse();
        try {
            filmopediaService.saveEntities(request.getFilmopediaDto());
            response.setResult("ok");
        }
        catch (Exception e){
            response.setResult(" ne ok");
        }
        return response;
    }

}
