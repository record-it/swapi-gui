package pl.wsb.repository;
import pl.wsb.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public interface SWPeopleRepository {
    List<Person> findAll();
    Optional<Person> findById(int id);

    void findByIdAsync(int id, Consumer<Person> callback);
}
