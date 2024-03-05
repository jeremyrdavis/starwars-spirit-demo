package io.arrogantprogrammer.swapi;

import io.arrogantprogrammer.swapi.domain.StarWarsCharacter;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
@QuarkusTestResource(SwapiClientTestResource.class)
public class SwapiClientTest {

    static final Logger LOGGER = LoggerFactory.getLogger(SwapiClientTest.class);

    @Inject
    @RestClient
    SwapiClient swapiClient;

    @Test
    public void testLukeSkywalker() {
        StarWarsCharacter luke = swapiClient.getCharacter(1);
        assertNotNull(luke);
        assertNotNull(luke.name());
        assertEquals("Luke Skywalker", luke.name());
        LOGGER.info("Luke Skywalker: {}", luke);
    }
}
