package ucodeacademy.com.day_05_pojo_api_model;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import ucodeacademy.utility.FruitShopUtil;

import static io.restassured.RestAssured.given;

public class TestProductPOJO extends FruitShopUtil {

    @Test
    public void getProducts(){
        Response response = given().accept(ContentType.JSON)
                .when()
                .get("/products");

        response.then().assertThat().statusCode(200);
    }


}
