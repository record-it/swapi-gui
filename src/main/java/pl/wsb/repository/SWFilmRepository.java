package pl.wsb.repository;

import pl.wsb.model.Film;

import java.util.Optional;

public interface SWFilmRepository {

    Optional<Film> findByUrl(String url);
}
