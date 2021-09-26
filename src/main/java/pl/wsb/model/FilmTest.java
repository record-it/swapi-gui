package pl.wsb.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmTest {
    public static String json = "{\n" +
            "\t\"title\": \"A New Hope\",\n" +
            "\t\"episode_id\": 4,\n" +
            "\t\"opening_crawl\": \"It is a period of civil war.\\r\\nRebel spaceships, striking\\r\\nfrom a hidden base, have won\\r\\ntheir first victory against\\r\\nthe evil Galactic Empire.\\r\\n\\r\\nDuring the battle, Rebel\\r\\nspies managed to steal secret\\r\\nplans to the Empire's\\r\\nultimate weapon, the DEATH\\r\\nSTAR, an armored space\\r\\nstation with enough power\\r\\nto destroy an entire planet.\\r\\n\\r\\nPursued by the Empire's\\r\\nsinister agents, Princess\\r\\nLeia races home aboard her\\r\\nstarship, custodian of the\\r\\nstolen plans that can save her\\r\\npeople and restore\\r\\nfreedom to the galaxy....\",\n" +
            "\t\"director\": \"George Lucas\",\n" +
            "\t\"producer\": \"Gary Kurtz, Rick McCallum\",\n" +
            "\t\"release_date\": \"1977-05-25\",\n" +
            "\t\"characters\": [\n" +
            "\t\t\"https://swapi.dev/api/people/1/\",\n" +
            "\t\t\"https://swapi.dev/api/people/2/\",\n" +
            "\t\t\"https://swapi.dev/api/people/3/\",\n" +
            "\t\t\"https://swapi.dev/api/people/4/\",\n" +
            "\t\t\"https://swapi.dev/api/people/5/\",\n" +
            "\t\t\"https://swapi.dev/api/people/6/\",\n" +
            "\t\t\"https://swapi.dev/api/people/7/\",\n" +
            "\t\t\"https://swapi.dev/api/people/8/\",\n" +
            "\t\t\"https://swapi.dev/api/people/9/\",\n" +
            "\t\t\"https://swapi.dev/api/people/10/\",\n" +
            "\t\t\"https://swapi.dev/api/people/12/\",\n" +
            "\t\t\"https://swapi.dev/api/people/13/\",\n" +
            "\t\t\"https://swapi.dev/api/people/14/\",\n" +
            "\t\t\"https://swapi.dev/api/people/15/\",\n" +
            "\t\t\"https://swapi.dev/api/people/16/\",\n" +
            "\t\t\"https://swapi.dev/api/people/18/\",\n" +
            "\t\t\"https://swapi.dev/api/people/19/\",\n" +
            "\t\t\"https://swapi.dev/api/people/81/\"\n" +
            "\t],\n" +
            "\t\"planets\": [\n" +
            "\t\t\"https://swapi.dev/api/planets/1/\",\n" +
            "\t\t\"https://swapi.dev/api/planets/2/\",\n" +
            "\t\t\"https://swapi.dev/api/planets/3/\"\n" +
            "\t],\n" +
            "\t\"starships\": [\n" +
            "\t\t\"https://swapi.dev/api/starships/2/\",\n" +
            "\t\t\"https://swapi.dev/api/starships/3/\",\n" +
            "\t\t\"https://swapi.dev/api/starships/5/\",\n" +
            "\t\t\"https://swapi.dev/api/starships/9/\",\n" +
            "\t\t\"https://swapi.dev/api/starships/10/\",\n" +
            "\t\t\"https://swapi.dev/api/starships/11/\",\n" +
            "\t\t\"https://swapi.dev/api/starships/12/\",\n" +
            "\t\t\"https://swapi.dev/api/starships/13/\"\n" +
            "\t],\n" +
            "\t\"vehicles\": [\n" +
            "\t\t\"https://swapi.dev/api/vehicles/4/\",\n" +
            "\t\t\"https://swapi.dev/api/vehicles/6/\",\n" +
            "\t\t\"https://swapi.dev/api/vehicles/7/\",\n" +
            "\t\t\"https://swapi.dev/api/vehicles/8/\"\n" +
            "\t],\n" +
            "\t\"species\": [\n" +
            "\t\t\"https://swapi.dev/api/species/1/\",\n" +
            "\t\t\"https://swapi.dev/api/species/2/\",\n" +
            "\t\t\"https://swapi.dev/api/species/3/\",\n" +
            "\t\t\"https://swapi.dev/api/species/4/\",\n" +
            "\t\t\"https://swapi.dev/api/species/5/\"\n" +
            "\t],\n" +
            "\t\"created\": \"2014-12-10T14:23:31.880000Z\",\n" +
            "\t\"edited\": \"2014-12-20T19:49:45.256000Z\",\n" +
            "\t\"url\": \"https://swapi.dev/api/films/1/\"\n" +
            "}";
    public static ObjectMapper MAPPER = new ObjectMapper();
    @Test
    public void shouldReturnValidTitle(){
        //given
        try {
            Film film = MAPPER.readValue(json, Film.class);
            //when
            String title = film.getTitle();
            //than
            assertEquals("A new Home", title);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}