package ucodeacademy.com.day_01_simple_request_and_validation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class SimplePostRequestAndVerify {

    @Test
    public void addProduct(){

        String postBody = """ 
            {
                "name": "Mangos,",
                "price": 2.79
            }
                """;

        // Response
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(postBody)
                .post("https://fruitshop2-predic8.azurewebsites.net/shop/v2/products");


        // we do validation/assertion using JUnit assertion
        Assert.assertEquals("Status code does not match",201, response.getStatusCode());

        Assert.assertTrue("Failed",!response.asString().isEmpty());
        Assert.assertFalse(response.asString().isEmpty());

        System.out.println(response.asString());




    }
}
