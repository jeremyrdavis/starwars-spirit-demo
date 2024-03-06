package io.arrogantprogrammer.dashboard;

import io.arrogantprogrammer.dashboard.api.DashboardAPI;
import io.arrogantprogrammer.domain.StarWarsSpiritAssignmentRecord;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.net.URI;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.slf4j.LoggerFactory.getLogger;

@QuarkusTest
public class LeaderboardTest {

    static final Logger LOGGER = getLogger(LeaderboardTest.class);

    @Inject
    DashboardAPI dashboardAPI;

    @BeforeEach
    public void setUp() {
        String[] names = {"Buddy", "Jovie", "Papa Elf", "Santa", "Miles", "Walter", "Emily", "Michael", "Morris"};
        IntStream.range(0, names.length).forEach(i -> {
            if (i == 1) {
                dashboardAPI.addStarWarsSpiritAssignment(new StarWarsSpiritAssignmentRecord(names[i], "https://swapi.dev/api/people/" + i + "/"));
                LOGGER.info("added StarWarsSpirit {} for {}", i + 1, names[i]);
            }else{
                dashboardAPI.addStarWarsSpiritAssignment(new StarWarsSpiritAssignmentRecord(names[i], "https://swapi.dev/api/people/" + (i + 1) + "/"));
                LOGGER.info("added StarWarsSpirit {} for {}", i + 1, names[i]);
            }
        });
    }

    @Test
    public void testLeaderBoard() {
        String mostPopularSpiritCharacterUrl = dashboardAPI.mostPopularSpiritCharacter();
        assertEquals("https://swapi.dev/api/people/1/", mostPopularSpiritCharacterUrl.toString());
    }

    @AfterEach
    public void tearDown() {
        dashboardAPI.allStarWarsSpiritAssignments().forEach(starWarsSpiritAssignmentRecord -> {
            LOGGER.info("starWarsSpiritAssignmentRecord: {}", starWarsSpiritAssignmentRecord);
        });
    }
}
