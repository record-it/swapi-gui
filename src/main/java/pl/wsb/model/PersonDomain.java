package pl.wsb.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class PersonDomain {
    private String name;
    private double height;
    private double mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private int birthYear;
    private String gender;
    private String homeworld;
    private List<Film> films;
    private List<String> species;
    private List<String> vehicles;
    private List<String> starships;
    private Timestamp created;
    private Timestamp edited;
    private String url;
}