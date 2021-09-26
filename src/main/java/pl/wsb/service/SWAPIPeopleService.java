package pl.wsb.service;

import pl.wsb.model.Person;
import pl.wsb.repository.SWPeopleRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SWAPIPeopleService implements SWPeopleService {

    private final SWPeopleRepository people;

    public SWAPIPeopleService(SWPeopleRepository people) {
        this.people = people;
    }

    public SWAPIPeopleService() {
        people = null;
    }

    @Override
    public Optional<Person> findById(int id) {
       return people.findById(id);
    }

    @Override
    public List<Person> findByHairColor(String color) {
        return people.findAll().stream()
                .filter(person -> color.equals(person.getHair_color()))
                .collect(Collectors.toList());
    }

    @Override
    public int countFilmsByPersonId(int id) {
        Optional<Person> person = people.findById(id);
        if (person.isPresent()){
            return person.get().getFilms().size();
        } else {
            return 0;
        }
    }
}
