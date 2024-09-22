package org.example.ex_15092024.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDstyle {

        @Test
        public static void testnonbdd() {

            String payload = "{\n" +
                    "    \"username\" : \"admin\",\n" +
                    "    \"password\" : \"password123\"\n" +
                    "           }";

            RequestSpecification r = RestAssured.given();
            r.baseUri("https://restful-booker.herokuapp.com");
            r.basePath("/auth");
            r.contentType(ContentType.JSON).log().all();
            r.body(payload);

            Response response= r.when().post();

            ValidatableResponse validatableResponse = response.then();
            validatableResponse.statusCode(200);
        }
    }
