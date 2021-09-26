package pl.wsb.service;

import pl.wsb.mapper.PersonMapper;
import pl.wsb.model.Film;
import pl.wsb.model.Person;
import pl.wsb.model.PersonDomain;
import pl.wsb.repository.SWFilmRepository;
import pl.wsb.repository.SWPeopleRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SWAPIPeopleService implements SWPeopleService {
    private final SWFilmRepository films;
    private final SWPeopleRepository people;

    public SWAPIPeopleService(SWFilmRepository films, SWPeopleRepository people) {
        this.films = films;
        this.people = people;
    }

    //TODO do usunięcia
    public SWAPIPeopleService() {
        people = null;
        films = null;
    }

    @Override
    public Optional<Person> findById(int id) {
       return people.findById(id);
    }

    @Override
    public Optional<PersonDomain> findDomainById(int id) {
        people.findByIdAsync(id, person -> {
            PersonDomain domain = PersonMapper.toDomain(person);
            domain.setFilms(new ArrayList<>());
            List<String> urls = person.getFilms();
            for(String url: urls){
                Optional<Film> film = films.findByUrl(url);
                if (film.isPresent()) {
                    domain.getFilms().add(film.get());
                }
            }

        });
        return Optional.empty();
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
