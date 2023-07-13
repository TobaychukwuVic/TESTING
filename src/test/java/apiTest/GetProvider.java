package apiTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GetProvider {

    @Test
    public void testGetProviders() {
        // Set the base URL
        RestAssured.baseURI = "https://plug-insure-auth.vercel.app";

        // Make the GET request
        Response response = RestAssured.get("/api/v1/provider/getProviders");

        // Retrieve the response body
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Verify the response status code
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 200);

    }
}

