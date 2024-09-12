package ucodeacademy.com.day_02_path_query_;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.junit.Test;

public class GetRequest {

    @BeforeClass
    public static void setUp(){
        //RestAssured.baseURI = the link to the website
        baseURI = "https://fruitshop2-predic8.azurewebsites.net/shop/v2";
    }
    @Test
    public void getAllVendors(){
        //get all vendors and print in the console response logs(all details)
        //log() (prettyPeak) response

        //given().get(baseURI + "/vendors").then().log().all(); //baseURI + "/vendors

        //given().get(baseURI + "/vendors").then().log().all();
        given().get("/vendors").then().log().all();

    }

    @Test
    public void getVendorById(){
//        given().pathParams("id", 1).when().get("/vendors/{id}")
//                .then().log().body();

        //the way we did in postman
        given().get("/vendors/3").then().log().body();

    }

    @Test
    public void getProductsQueryParam(){
        given()
                .queryParam("name", "Orange")
                .queryParam("start",2)
                .queryParam("limit",100)
                .when().get("/products")
                .then().log().body();
    }
}
