package io.arrogantprogrammer.swapi.domain;

import java.net.URI;
import java.util.List;

public record CharactersResponse(int count, URI next, URI previous, List<StarWarsCharacter> results){}
