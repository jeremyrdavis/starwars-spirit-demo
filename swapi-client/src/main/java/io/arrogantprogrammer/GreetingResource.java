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

import java.util.Random;

@Path("/hello")
public class GreetingResource {

    private static int count;

    static final Logger LOGGER = LoggerFactory.getLogger(GreetingResource.class);

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
        return swapiClient.getCharacter( new Random().nextInt(count - 1) + 1);
    }
}
