package pl.wsb.mapper;

import pl.wsb.model.Person;
import pl.wsb.model.PersonDomain;

public class PersonMapper {
    static public PersonDomain toDomain(Person person){
        //TODO dodać mapowanie pozostałych pól!!!
        return PersonDomain.builder()
                .name(person.getName())
                .height(Double.parseDouble(person.getHeight()))
                .birthYear(person.getBirth_year())
                .mass(Double.parseDouble(person.getMass()))
                .created(person.getCreated())
                .edited(person.getEdited())
                .url(person.getUrl())
                .build();
    }
}
