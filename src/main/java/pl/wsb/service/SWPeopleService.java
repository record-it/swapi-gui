package pl.wsb.service;

import pl.wsb.model.Person;

import java.util.List;
import java.util.Optional;

public interface SWPeopleService {
    Optional<Person> findById(int id);
    List<Person> findByHairColor(String color);

    int countFilmsByPersonId(int id);
}
