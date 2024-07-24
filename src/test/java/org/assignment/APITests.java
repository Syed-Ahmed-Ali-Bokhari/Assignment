package org.assignment;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.assignment.config.RestAssuredConfig;
import org.assignment.utils.ExtentReportManager;
import org.assignment.utils.Payloads;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITests {

    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setup() {
        RestAssuredConfig.setup();
        extent = ExtentReportManager.getInstance();
    }

    @Test
    public void testBrandLead() {
        test = extent.createTest("testBrandLead", "Verify POST Brand Lead API");

        String requestBody = Payloads.getBrandPayload();
        test.info("Request Payload: " + requestBody);

        Response response = given()
                .spec(RestAssuredConfig.getRequestSpecification())
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200) // or the expected status code
                .extract()
                .response();

        test.info("Response: " + response.asString());

        if (response.statusCode() == 200) {
            test.pass("POST Brand Lead API test passed");
        } else {
            test.fail("POST Brand Lead API test failed");
        }

        System.out.println(response.asString());
    }

    @Test
    public void testWalletLead() {
        test = extent.createTest("testWalletLead", "Verify POST Wallet Lead API");

        String requestBody = Payloads.getWalletPayload();
        test.info("Request Payload: " + requestBody);

        Response response = given()
                .spec(RestAssuredConfig.getRequestSpecification())
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200) // or the expected status code
                .extract()
                .response();

        test.info("Response: " + response.asString());

        if (response.statusCode() == 200) {
            test.pass("POST Wallet Lead API test passed");
        } else {
            test.fail("POST Wallet Lead API test failed");
        }

        System.out.println(response.asString());
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
    }
}
