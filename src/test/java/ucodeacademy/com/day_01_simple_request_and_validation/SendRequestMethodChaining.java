package ucodeacademy.com.day_01_simple_request_and_validation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class SendRequestMethodChaining {

    @Test
    public void requestMethodChaining(){
        String baseUrl = "https://fruitshop2-predic8.azurewebsites.net/shop/v2/products";

        Response response = RestAssured.given().baseUri(baseUrl)
                .when().get();
        response.prettyPrint();

        Assert.assertEquals(200,response.statusCode());

    }

    //if you want to do validation/verification directly without storing the response
    @Test
    public void sendRequestAndValidateDirectly(){
        String baseUrl = "https://fruitshop2-predic8.azurewebsites.net/shop/v2/products";

        RestAssured.given().when().get(baseUrl).then().statusCode(200)
                .and()
                .header("Content-Type", "application/json");

    }
}
