package pl.wsb.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.wsb.api.ApiHelper;
import pl.wsb.model.Film;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SWAPIFilmRepository implements SWFilmRepository{
    public static final ObjectMapper MAPPER = new ObjectMapper();
    public static final String SWAPI_DEV_API_FILMS = "https://swapi.dev/api/films/";
    private Map<String, Film> cache = new HashMap<>();
    @Override
    public Optional<Film> findByUrl(String url) {
        if (cache.containsKey(url)){
            return Optional.of(cache.get(url));
        }
        try {
            String json = ApiHelper.getBodyFromApi(url);
            Film film = MAPPER.readValue(json, Film.class);
            cache.put(url, film);
            return Optional.of(film);
        } catch (URISyntaxException e) {
            return Optional.empty();
        } catch (IOException e) {
            return Optional.empty();
        } catch (InterruptedException e) {
            return Optional.empty();
        }
    }
}
