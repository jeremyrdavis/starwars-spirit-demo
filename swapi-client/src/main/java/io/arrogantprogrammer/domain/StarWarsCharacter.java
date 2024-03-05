package io.arrogantprogrammer.domain;

import java.net.URI;
import java.time.Instant;
import java.util.List;

public record StarWarsCharacter(
        String name,
        int height,
        int mass,
        String hairColor,
        String skinColor,
        String eyeColor,
        String birthYear,
        String gender,
        URI homeworld,
        List<URI> films,
        List<URI> species,
        List<URI> vehicles,
        List<URI> starships,
        Instant created,
        Instant edited,
        URI url) {}
