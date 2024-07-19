package org.assignment;

import io.restassured.response.Response;
import org.assignment.config.RestAssuredConfig;
import org.assignment.utils.Payloads;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APITests {

    @BeforeClass
    public void setup() {
        RestAssuredConfig.setup();
    }

    @Test
    public void testBrandLead() {
        String requestBody = Payloads.getBrandPayload();

        Response response = given()
                .spec(RestAssuredConfig.getRequestSpecification())
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200) // or the expected status code
                .extract()
                .response();

        System.out.println(response.asString());
    }
    @Test
    public void testWalletLead() {
        String requestBody = Payloads.getWalletPayload();

        Response response = given()
                .spec(RestAssuredConfig.getRequestSpecification())
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200) // or the expected status code
                .extract()
                .response();

        System.out.println(response.asString());
    }
}
