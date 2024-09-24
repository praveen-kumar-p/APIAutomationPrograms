package org.example.ex_22092024.Jsonpath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class JSONPath001 {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;

    @Test
    public void test_post() {
        String payload_POST = "{\n" +
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
        requestSpecification.body(payload_POST);

        Response response = requestSpecification.when().post();

        System.out.println(response.asString());

        JsonPath jsonpath = new JsonPath(response.asString());
        String bookingid = jsonpath.getString("bookingid");
        String firstname = jsonpath.getString(".booking.firstname");
        String checkin = jsonpath.getString(".booking.bookingdates.checkin");
        System.out.println(bookingid);
        System.out.println(firstname);
        System.out.println(checkin);

        assertThat(bookingid).isNotNull().isNotEmpty();
        assertThat(firstname).isNotEqualTo("Pramod");

        // Get Validatable response to perform validation



    }
}