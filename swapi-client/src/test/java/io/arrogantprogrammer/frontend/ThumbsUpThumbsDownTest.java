package io.arrogantprogrammer.frontend;

import io.arrogantprogrammer.dashboard.StarWarsSpiritAssignment;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.fail;

@QuarkusTest
public class ThumbsUpThumbsDownTest extends PreInititializedAssignmentsTest{

    @Test
    public void testThumbsUp() {
        StarWarsSpiritAssignment starWarsSpiritAssignment = (StarWarsSpiritAssignment) StarWarsSpiritAssignment.findByIdOptional(1).get();
        if (starWarsSpiritAssignment == null) {
            fail();
        }

        String requestBody = """
                {
                    "id":"1",
                    "thumbsUpThumbDown":"THUMBS_UP"
                }                
                """;
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .patch("/hello/thumbsUpThumbsDown")
                .then()
                .extract().response();
        Assertions.assertEquals(200, response.statusCode());

    }

}
