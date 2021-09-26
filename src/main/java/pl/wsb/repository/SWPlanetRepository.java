package pl.wsb.repository;

import pl.wsb.model.Planet;

import java.util.Optional;

public interface SWPlanetRepository {
    Optional<Planet> findById(int id);
}
