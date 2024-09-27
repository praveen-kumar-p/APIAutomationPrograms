package org.example.ex_22092024.GSONPUT;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Deserialization {

    RequestSpecification r = RestAssured.given();
    Response response;

    ValidatableResponse validatableResponse;

    // Serialization

    @Description("TC#1 - verify that create booking is working with valid payload")
    @Test
    public void testNonBDDstylepostpositive() {

        booking booking = new booking();
        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositepaid(true);

        bookingdates bookingdates = new bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        Gson gson = new Gson();
        String jsonstring = gson.toJson(booking);
        System.out.println(jsonstring);

        String base_url = "https://restful-booker.herokuapp.com";
        String base_path = "/booking";

        r.baseUri(base_url);
        r.basePath(base_path);
        r.contentType(ContentType.JSON).log().all();
        r.body(jsonstring);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        bookingresponse bookingresponse = gson.fromJson(responseString, bookingresponse.class);
        System.out.println(bookingresponse.getBookingid());
        System.out.println();

    }
}
