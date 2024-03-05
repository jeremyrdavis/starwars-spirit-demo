package io.arrogantprogrammer.swapi.domain;

import io.arrogantprogrammer.domain.StarWarsCharacter;

import java.net.URI;
import java.util.List;

public record CharactersResponse(int count, URI next, URI previous, List<StarWarsCharacter> results){}
