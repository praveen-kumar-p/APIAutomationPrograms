package org.example.ex_22092024.GSON;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.beans.Transient;

public class Serialization {

    //{
    //    "firstname" : "Jim",
    //    "lastname" : "Brown",
    //    "totalprice" : 111,
    //    "depositpaid" : true,
    //    "bookingdates" : {
    //        "checkin" : "2018-01-01",
    //        "checkout" : "2019-01-01"
    //    },
    //    "additionalneeds" : "Breakfast"
    //}

    RequestSpecification r = RestAssured.given();
    Response response= r.when().post();

    ValidatableResponse validatableResponse = response.then();

    @Description("TC#1 - verify that create booking is working with valid payload")
    @Transient
    public void testNonBDDstylepostpositive(){

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

//        String base_url = "https://restful-booker.herokuapp.com";
//        String base_path = "/auth";
//        r.contentType(ContentType.JSON).log().all();
////        r.body(payload);
//
//        response = r.when().log().all().post();
//        String responseString = response.asString();
//        System.out.println(responseString);
//
//        ValidatableResponse validatableResponse = response.then();
//        validatableResponse.statusCode(200);


    }
}
