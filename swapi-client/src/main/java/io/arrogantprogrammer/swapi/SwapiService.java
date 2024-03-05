package io.arrogantprogrammer.swapi;

import io.arrogantprogrammer.domain.StarWarsCharacter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Random;

@ApplicationScoped
public class SwapiService {

    static final Logger LOGGER = LoggerFactory.getLogger(SwapiService.class);
    private static int count;
    private static HashMap<Integer, StarWarsCharacter> characters = new HashMap<>();

    @Inject
    @RestClient
    SwapiClient swapiClient;

    public StarWarsCharacter getRandomStarWarsCharacter() {

        // if we don't know how many characters there are, find out
        if (count == 0) {
            count = swapiClient.getAllCharacters().count();
            LOGGER.debug("Found {} characters", count);
        }

        // get a random character
        int random = new Random().nextInt(count - 1) + 1;
        LOGGER.debug("Getting character {}", random);

        if(characters.containsKey(random)){
            LOGGER.debug("Returning cached character {}", random);
            return characters.get(random);
        }else {
            StarWarsCharacter starWarsCharacter = swapiClient.getCharacter( new Random().nextInt(count - 1) + 1);
            LOGGER.debug("Caching character {}", random);
            characters.put(count, starWarsCharacter);
            return starWarsCharacter;
        }
    }
}
