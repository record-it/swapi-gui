package pl.wsb.service;

import pl.wsb.model.Planet;

import java.util.Optional;

public interface SWPlanetService {
    public Optional<Planet> findById(int id);
}
