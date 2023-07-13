package apiTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Login {

    @Test
    public void testUserLogin() {
        // Set the base URL
        RestAssured.baseURI = "https://plug-insure-auth.vercel.app";

        // Define the request body
        String requestBody = "{\n" +
                "    \"email\": \"ssukohatobay@gmail.com\",\n" +
                "    \"password\": \"P@ssword@25\",\n" +
                "    \"grantType\": \"password\",\n" +
                "    \"clientId\": \"PPYaXQZc7Jz9O5We\"\n" +
                "}";

        // Make the POST request for login
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/v1/user/login");

        // Retrieve the response body
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Verify the response status code
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 200);

    }
}

