package io.arrogantprogrammer.frontend;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class StarWarsSpiritAssignmentRecordCharacterCountTest extends PreInititializedAssignmentsTest {

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
