package org.example.ex_22092024.pojos;

import java.util.LinkedHashMap;
import java.util.Map;

public class pojohashmap {
    public static void main(String[] args) {

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
    }
}
