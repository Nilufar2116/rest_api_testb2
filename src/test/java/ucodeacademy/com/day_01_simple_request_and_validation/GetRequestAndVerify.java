package ucodeacademy.com.day_01_simple_request_and_validation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class GetRequestAndVerify {

    @Test
    public void getRequestAndValidate(){

        Response response = RestAssured.given()
                .get("https://fruitshop2-predic8.azurewebsites.net/shop/v2/products");

        //verify status code
        Assert.assertEquals("Failed", 200, response.getStatusCode());

        //verify content type
        Assert.assertEquals("Failed","application/json", response.getContentType());

        System.out.println(response.asString());
        System.out.println("-------------------------------------------");

        System.out.println(response.asPrettyString());

        System.out.println("-------------------------------------------------------");

        response.prettyPeek();

        System.out.println("----------------------------------");

        response.prettyPrint();

        System.out.println(response.body().asString());

    }
}
