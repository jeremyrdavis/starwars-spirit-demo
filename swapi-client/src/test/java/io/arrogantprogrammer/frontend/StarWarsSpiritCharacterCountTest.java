package io.arrogantprogrammer.frontend;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Arrays;
import java.util.stream.IntStream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class StarWarsSpiritCharacterCountTest {

    static final Logger LOGGER = LoggerFactory.getLogger(StarWarsSpiritCharacterCountTest.class);

    @BeforeAll
    @Transactional
    public static void setUp() {
        LOGGER.info("Running beforeEach");
        String[] names = {"Buddy", "Jovie", "Papa Elf", "Santa", "Miles", "Walter", "Emily", "Michael", "Morris"};
        Arrays.stream(names).forEach(name -> {
            new StarWarsSpirit(name, URI.create("https://swapi.dev/api/people/1/")).persist();
            LOGGER.info("persisted StarWarsSpirit for {}", name);
        });
    }

    @Test
    public void testCharacterCount() {
        LOGGER.info("Running testCharacterCount");
        given()
                .when().get("/hello/spirits")
                .then()
                .statusCode(200)
                .body(containsString("Buddy"));
    }
}
