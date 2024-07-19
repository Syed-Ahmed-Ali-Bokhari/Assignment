package org.assignment.config;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RestAssuredConfig {

    public static void setup() {
        RestAssured.baseURI = "https://api.tap.company/v3/connect/lead";
    }

    public static RequestSpecification getRequestSpecification() {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer sk_live_o1any5GIsVmYiU7wdZJ2gPjE")
                .contentType("application/json");
    }
}
