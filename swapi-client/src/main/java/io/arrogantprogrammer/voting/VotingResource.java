package io.arrogantprogrammer.voting;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/voting")
public class VotingResource {

    static final Logger LOGGER = LoggerFactory.getLogger(VotingResource.class);

    @POST
    @Path("/ilikemycharacter")
    public void voteForCharacter() {
        LOGGER.info("Voting for character");
    }
}
