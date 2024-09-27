package org.example.ex_22092024.GSONPOST;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class SERIALPOST {

    RequestSpecification r = RestAssured.given();
    Response response;

    ValidatableResponse validatableResponse;


    //{
    //    "firstname" : "Harsha",
    //    "lastname" : "kumar",
    //    "totalprice" : 4019,
    //    "depositpaid" : true,
    //    "bookingdates" : {
    //        "checkin" : "2024-09-18",
    //        "checkout" : "2024-09-18"
    //    },
    //    "additionalneeds" : "BreakFast"
    //}


    public void testpost(){


    }
}
