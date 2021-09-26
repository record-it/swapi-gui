package pl.wsb.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.wsb.api.ApiHelper;
import pl.wsb.model.Person;
import pl.wsb.model.Persons;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.function.Consumer;

public class SWAPIPeopleRepository implements SWPeopleRepository {
    public static final ObjectMapper MAPPER = new ObjectMapper();
    public static final String SWAPI_DEV_API_PEOPLE = "https://swapi.dev/api/people/";
    private Map<Integer, Person> cache = new HashMap<>();
    private List<Person> personsList = new ArrayList<>();

    @Override
    public List<Person> findAll() {
        if (personsList.isEmpty()) {
            getPage(SWAPI_DEV_API_PEOPLE);
        }
        return personsList;
    }

    @Override
    public Optional<Person> findById(int id) {
        if (cache.containsKey(id)) {
            return Optional.of(cache.get(id));
        } else {
            try {
                ApiHelper.getObjectFromApi(SWAPI_DEV_API_PEOPLE + id, id, body -> {
                    try {
                        Person person = MAPPER.readValue(body, Person.class);
                        cache.put(id, person);
                        System.out.println("Szukana osoba jest już dostępna!");
                    } catch (JsonProcessingException e) {
                        System.err.println(e.getMessage());
                    }
                });
            } catch (URISyntaxException e) {
                System.err.println(e.getMessage());
            }
            return Optional.empty();
        }
    }

    @Override
    public Optional<Person> findByIdSync(int id) {
        if (cache.containsKey(id)){
            return Optional.of(cache.get(id));
        }
        try {
            String body = ApiHelper.getBodyFromApi(SWAPI_DEV_API_PEOPLE + id);
            Person person = MAPPER.readValue(body, Person.class);
            cache.put(id, person);
            return Optional.of(person);
        } catch (URISyntaxException e) {
            return Optional.empty();
        } catch (IOException e) {
            return Optional.empty();
        } catch (InterruptedException e) {
            return Optional.empty();
        }
    }

    @Override
    public void findByIdAsync(int id, Consumer<Person> callback) {
        if (cache.containsKey(id)) {
           callback.accept(cache.get(id));
        } else {
            try {
                ApiHelper.getObjectFromApi(SWAPI_DEV_API_PEOPLE + id, id, body -> {
                    try {
                        Person person = MAPPER.readValue(body, Person.class);
                        cache.put(id, person);
                        callback.accept(person);
                    } catch (JsonProcessingException e) {
                        System.err.println(e.getMessage());
                    }
                });
            } catch (URISyntaxException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void getPage(String nextPage) {
        try {
            ApiHelper.getObjectFromApi(SWAPI_DEV_API_PEOPLE, 0, body -> {
                try {
                    Persons persons = MAPPER.readValue(body, Persons.class);
                    personsList.addAll(persons.getResults());
                    if (persons.getNext() != null){
                        getPage(persons.getNext());
                    } else {
                        for (int i = 0; i < personsList.size(); i++){
                            cache.put(i + 1, personsList.get(i));
                        }
                    }
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            });
        } catch (URISyntaxException e) {
            System.err.println(e.getMessage());
        }
    }
}
