package org.example;

import io.restassured.RestAssured;
public class Test001 {

    public static void main(String[] args) {

        System.out.println("Rest Assured Test Case");

        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/booking/1").log().all()
                .when()
                    .get()
                .then().log().all()
                    .statusCode(200);
    }
}
