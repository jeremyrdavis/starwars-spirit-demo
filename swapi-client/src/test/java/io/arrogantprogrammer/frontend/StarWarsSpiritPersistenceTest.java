package io.arrogantprogrammer.frontend;

import io.arrogantprogrammer.swapi.SwapiClientTestResource;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
@QuarkusTestResource(SwapiClientTestResource.class)
public class StarWarsSpiritPersistenceTest {
    static final Logger LOGGER = LoggerFactory.getLogger(StarWarsSpiritPersistenceTest.class);

    @Test
    public void testStarWarsSpiritCharacter() {
        LOGGER.info("Running testStarWarsSpiritCharacter");

        given()
                .when().get("/hello/Buddy")
                .then()
                .statusCode(200)
                .body(containsString("Hello, Buddy!  Your Star Wars Spirit character is"));

        assertTrue(StarWarsSpirit.count() > 0);
    }
}
