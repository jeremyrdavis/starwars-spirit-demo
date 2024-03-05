package io.arrogantprogrammer.swapi;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.util.Collections;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class SwapiClientTestResource implements QuarkusTestResourceLifecycleManager {

    static final String SWAPI_URL = "https://swapi.dev/api";

    WireMockServer wiremockServer;

    @Override
    public Map<String, String> start() {
        wiremockServer = new WireMockServer();
        wiremockServer.start();
        stubFor(get(urlEqualTo("/people/1/"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(
                                """
                                    {
                                        "name": "Luke Skywalker",
                                        "height": "172",
                                        "mass": "77",
                                        "hair_color": "blond",
                                        "skin_color": "fair",
                                        "eye_color": "blue",
                                        "birth_year": "19BBY",
                                        "gender": "male",
                                        "homeworld": "https://swapi.dev/api/planets/1/",
                                        "films": [
                                            "https://swapi.dev/api/films/2/",
                                            "https://swapi.dev/api/films/6/",
                                            "https://swapi.dev/api/films/3/",
                                            "https://swapi.dev/api/films/1/",
                                            "https://swapi.dev/api/films/7/"
                                        ],
                                        "species": [
                                            "https://swapi.dev/api/species/1/"
                                        ],
                                        "vehicles": [
                                            "https://swapi.dev/api/vehicles/14/",
                                            "https://swapi.dev/api/vehicles/30/"
                                        ],
                                        "starships": [
                                            "https://swapi.dev/api/starships/12/",
                                            "https://swapi.dev/api/starships/22/"
                                        ],
                                        "created": "2014-12-09T13:50:51.644000Z",
                                        "edited": "2014-12-20T21:17:56.891000Z",
                                        "url": "https://swapi.dev/api/people/1/"
                                    }
                                """
                        )));

        stubFor(get(urlMatching(".*")).atPriority(10)
                .willReturn(aResponse().proxiedFrom(SWAPI_URL)));

        return Collections.singletonMap("io.arrogantprogrammer.swapi.SwapiService/mp-rest/url", wiremockServer.baseUrl());
    }

    @Override
    public void stop() {
        if (null != wiremockServer) {
            wiremockServer.stop();
        }
    }
}
