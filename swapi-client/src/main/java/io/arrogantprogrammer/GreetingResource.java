package io.arrogantprogrammer;

import io.arrogantprogrammer.swapi.SwapiClient;
import io.arrogantprogrammer.swapi.domain.StarWarsCharacter;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Random;

@Path("/hello")
public class GreetingResource {
    static final Logger LOGGER = LoggerFactory.getLogger(GreetingResource.class);

    private static int count;

    private static HashMap<Integer, StarWarsCharacter> characters = new HashMap<>();

    @RestClient
    SwapiClient swapiClient;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/spiritcharacter")
    @Produces(MediaType.APPLICATION_JSON)
    public StarWarsCharacter getCharacter() {
        if (count == 0) {
            count = swapiClient.getAllCharacters().count();
        }
        if(characters.containsKey(count)){
            return characters.get(count);
        }else {
            StarWarsCharacter starWarsCharacter = swapiClient.getCharacter( new Random().nextInt(count - 1) + 1);
            characters.put(count, starWarsCharacter);
            return starWarsCharacter;
        }
    }

    @GET
    @Path("/charactercount")
    public int getCharacterCount() {
        if (count == 0) {
            count = swapiClient.getAllCharacters().count();
        }
        return count;
    }
}
