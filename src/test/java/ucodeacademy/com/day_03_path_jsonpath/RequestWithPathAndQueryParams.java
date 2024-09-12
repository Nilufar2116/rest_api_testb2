package ucodeacademy.com.day_03_path_jsonpath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RequestWithPathAndQueryParams {

    @BeforeClass
    public static void setUp(){
        baseURI = "https://fruitshop2-predic8.azurewebsites.net/shop/v2";
    }

    @Test
    public void getProductByIdPathParam(){

        Response response = given().accept(ContentType.JSON)
                .pathParams("id", 14)
                .when().get("/products/{id}");

        response.prettyPrint();
    }

    @Test
    public void getProductQueryParam(){
        Response response = given().accept(ContentType.JSON)
                .queryParam("price", "<10")
                .queryParam("limit", 30)
                .get("/products");

        response.prettyPrint();
    }


}
