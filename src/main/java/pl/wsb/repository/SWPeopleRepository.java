package pl.wsb.repository;
import pl.wsb.model.Person;

import java.util.List;
import java.util.Optional;

public interface SWPeopleRepository {
    List<Person> findAll();
    Optional<Person> findById(int id);
}
