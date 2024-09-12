package ucodeacademy.com.day_02_path_query_;

import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class PostRequest {

    @BeforeClass
    public static void setUps(){
        baseURI = "https://fruitshop2-predic8.azurewebsites.net/shop/v2";
    }

    String postBody = """
            {
              "name": "Melon,",
              "price": 7.79
            }
            """;

    @Test
    public void addNewProduct(){
        given().contentType(ContentType.JSON)
                .body(postBody).when().post("/products")
                .then().statusCode(201)
                .body("name", is("Melon,"))
                .log().body();


    }

    @Test
    public void deleteProduct(){
        given().pathParams("id",23)
                .when().delete("/products/{id}")
                .then().log().body()
                .log().status();
    }
}
