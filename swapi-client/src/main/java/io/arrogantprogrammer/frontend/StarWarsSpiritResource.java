package io.arrogantprogrammer.frontend;

import io.arrogantprogrammer.dashboard.api.DashboardAPI;
import io.arrogantprogrammer.domain.StarWarsSpiritAssignmentRecord;
import io.arrogantprogrammer.swapi.SwapiService;
import io.arrogantprogrammer.domain.StarWarsCharacter;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("/hello")
public class StarWarsSpiritResource {

    @Inject
    SwapiService swapiService;

    @Inject
    DashboardAPI dashboardAPI;

    static final Logger LOGGER = LoggerFactory.getLogger(StarWarsSpiritResource.class);

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String hello(@PathParam("name") String name) {
        LOGGER.info("Running hello");
        StarWarsCharacter starWarsCharacter = swapiService.getRandomStarWarsCharacter();
        dashboardAPI.addStarWarsSpiritAssignment(new StarWarsSpiritAssignmentRecord(name, starWarsCharacter.url()));
        return "Hello, %s!  Your Star Wars Spirit character is %s.".formatted(name, starWarsCharacter.name());
    }

    @GET
    @Path("/spirits")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StarWarsSpiritAssignmentRecord> allSpirits() {
        LOGGER.info("Running allSpirits");
        return dashboardAPI.allStarWarsSpiritAssignments();
    }
}
