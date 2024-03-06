package io.arrogantprogrammer.frontend;

import io.arrogantprogrammer.dashboard.DashboardAPIImpl;
import io.arrogantprogrammer.domain.StarWarsSpiritAssignmentRecord;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.stream.IntStream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class StarWarsSpiritAssignmentRecordCharacterCountTest {

    static final Logger LOGGER = LoggerFactory.getLogger(StarWarsSpiritAssignmentRecordCharacterCountTest.class);

    @Inject
    DashboardAPIImpl dasboardAPI;

    @BeforeEach
    @Transactional
    public void setUp() {
        LOGGER.info("Running beforeEach");
        String[] names = {"Buddy", "Jovie", "Papa Elf", "Santa", "Miles", "Walter", "Emily", "Michael", "Morris"};
        IntStream.range(0, names.length).forEach(i -> {
            dasboardAPI.addStarWarsSpiritAssignment(new StarWarsSpiritAssignmentRecord(names[i], "https://swapi.dev/api/people/" + (i + 1) + "/"));
            LOGGER.info("added StarWarsSpirit for {}", names[i]);
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
