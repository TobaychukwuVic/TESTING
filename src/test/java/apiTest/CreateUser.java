package apiTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CreateUser {

    @Test
    public void testSignUp() {
        String randomEmail = UUID.randomUUID().toString() + "@gmail.com";
        // Set the base URL
        RestAssured.baseURI = "https://plug-insure-auth.vercel.app";

        // Define the request body with the required "clientId" field
        String requestBody = "{\n" +
                "    \"email\": \"" + randomEmail + "\",\n" +
                "    \"firstName\": \"Priscilla\",\n" +
                "    \"lastName\": \"Gomez\",\n" +
                "    \"userType\": \"customer\",\n" +
                "    \"password\": \"P@ssword@25\",\n" +
                "    \"confirmPassword\": \"P@ssword@25\",\n" +
                "    \"clientId\": \"PPYaXQZc7Jz9O5Wj\"\n" +
                "}";

        // Make the POST request
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/v1/user/signUp");

        // Retrieve the response body
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Verify the response status code
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 201);

    }

}

