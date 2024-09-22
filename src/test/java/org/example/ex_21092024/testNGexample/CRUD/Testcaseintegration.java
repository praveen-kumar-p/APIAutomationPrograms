package org.example.ex_21092024.testNGexample.CRUD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Testcaseintegration {

    // Create a Token
    // Create a booking
    // Perform a put request
    // Verify that PUT is success by GET request
    // Delete the ID
    // Verify it doesn't exist GET Request

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    String bookingId;

    public String getToken() {

        String payload = "{\n" +
                "                    \"username\" : \"admin\",\n" +
                "                    \"password\" : \"password123\"\n" +
                "                }";

        // Given - Request Spec
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

        // When -     Response
        Response response = r.when().post();

        // Then - ValidatableResponse
        // Validation
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        // Extract the token
        token = response.jsonPath().getString("token") ;
        System.out.println(token);
        return token;
    }


    public String getbookingID(){

        String payload_POST= "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST).log().all();

        Response response = requestSpecification.when().post();

        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        bookingId = response.jsonPath().getString("bookingid");
        System.out.println(bookingId);
        return bookingId;
    }


    @Test(priority = 1)
    public void test_update_PUT(){
        token = getToken();
        bookingId = getbookingID();

        String payloadPUT= "{\n" +
                "    \"firstname\" : \"Harsha\",\n" +
                "    \"lastname\" : \"shavi\",\n" +
                "    \"totalprice\" : 9972,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-09-20\",\n" +
                "        \"checkout\" : \"2024-09-20\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadPUT).log().all();

        Response response = requestSpecification.when().put();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }

    @Test(priority = 2)
    public void test_update_GET(){
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        System.out.println(bookingId);
    }

    @Test(priority = 3)
    public void test_delete_booking(){
        System.out.println(bookingId);
        System.out.println(token);
    }

    @Test(priority = 4)
    public void test_after_delete_GET(){
        System.out.println(bookingId);
    }

}
