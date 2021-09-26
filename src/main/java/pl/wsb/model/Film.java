package pl.wsb.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Film {
    private String title;
    private int episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;
    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;
    private Timestamp created;
    private Timestamp edited;
    private String url;
}
