package io.arrogantprogrammer.domain;

import java.time.Instant;
import java.util.List;

public record StarWarsCharacter(
        String name,
        String height,
        String mass,
        String hairColor,
        String skinColor,
        String eyeColor,
        String birthYear,
        String gender,
        String homeworld,
        List<String> films,
        List<String> species,
        List<String> vehicles,
        List<String> starships,
        Instant created,
        Instant edited,
        String url) {}
