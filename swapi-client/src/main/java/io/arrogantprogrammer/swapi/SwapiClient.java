package io.arrogantprogrammer.swapi;

import io.arrogantprogrammer.swapi.domain.CharactersResponse;
import io.arrogantprogrammer.domain.StarWarsCharacter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
@ApplicationScoped
public interface SwapiClient {

    @GET
    @Path("/people/{id}/")
    StarWarsCharacter getCharacter(@PathParam("id") int id);
    @GET
    @Path("people/")
    CharactersResponse getAllCharacters();
}
