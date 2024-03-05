package io.arrogantprogrammer.frontend;

import io.arrogantprogrammer.swapi.SwapiService;
import io.arrogantprogrammer.swapi.domain.StarWarsCharacter;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")
public class StarWarsSpiritResource {

    @Inject
    SwapiService swapiService;

    static final Logger LOGGER = LoggerFactory.getLogger(StarWarsSpiritResource.class);

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("name") String name) {
        LOGGER.info("Running hello");
        StarWarsCharacter starWarsCharacter = swapiService.getRandomStarWarsCharacter();
        return "%s, your Star Wars Spirit character is %s.".formatted(name, starWarsCharacter.name());
    }
}
