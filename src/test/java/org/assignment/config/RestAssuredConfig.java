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
                // Remove the hard-coded secret
                .header("Authorization", "Bearer YOUR_API_KEY") // Replace with a placeholder or use environment variables
                .contentType("application/json");
    }
}
