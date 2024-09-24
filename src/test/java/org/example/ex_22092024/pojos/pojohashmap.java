package org.example.ex_22092024.pojos;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class pojohashmap {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    String bookingId;


    @Test
    public void test_post_with_hashmap(){

        //{
        //    "firstname" : "Praveen",
        //    "lastname" : "Iyli",
        //    "totalprice" : 4018,
        //    "depositpaid" : true,
        //    "bookingdates" : {
        //        "checkin" : "2024-09-03",
        //        "checkout" : "2024-09-03"
        //    },
        //    "additionalneeds" : "Lunch"
        //}


        Map<String, Object> jsonbody = new LinkedHashMap<>();
        jsonbody.put("firstname", "Praveen");
        jsonbody.put("lastname", "Iyli");
        jsonbody.put("totalprice", "4018");
        jsonbody.put("depositpaid", "true");

        Map<String, Object> insidebody = new LinkedHashMap<>();
        insidebody.put("checkin", "2024-09-03");
        insidebody.put("checkout", "2024-09-03");

        jsonbody.put("bookingdates", insidebody);
        jsonbody.put("additionalneeds", "Lunch");

        System.out.println(jsonbody);


        RequestSpecification r = RestAssured.given();
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonbody).log().all();

        Response response = requestSpecification.when().post();

        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        bookingId = response.jsonPath().getString("bookingid");
        System.out.println(bookingId);
    }
}
