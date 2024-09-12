package ucodeacademy.com.day_03_path_jsonpath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class GetRequest {

    @BeforeClass
    public static void setUp(){
        baseURI = "https://fruitshop2-predic8.azurewebsites.net/shop/v2";
    }

    @Test
    public void getAllProductsAndVerify(){
        Response response = given().accept(ContentType.JSON)
                .when()
                .get("/products");

        //assertion - verify status using JUnit assertion
        Assert.assertEquals(200,response.getStatusCode());

        //assertion - verify suing build-in assertion/RestAssured assertion
        response.then().assertThat().statusCode(200)
                .assertThat().contentType(ContentType.JSON);

        //using log() to print response body on the console
        response.then().log().body();
        System.out.println("------------------------------------------------------");

        //print using prettyPrint to print response body on the console
        response.prettyPrint();
    }

    @Test
    public void getAllProductsAndVerify2(){

        Response response = given().accept(ContentType.JSON)
                .queryParam("limit", 30)
                .when().get("/products");

        response.then().assertThat().statusCode(200);

        //extract a product name from products (any product name)
        String productName = response.path("products[1].name");

        System.out.println("Product Name:" +productName);

        int productId = response.path("products[1].id");

        System.out.println("Product ID: " +productId);

        int totalProduct = response.path("products.size()");
        System.out.println("Total products: "+ totalProduct);

        System.out.println("-----------------------------------------------------");


        //loop through each product and print/verify each ID and name

        for (int i = 0; i < totalProduct; i++) {

            String eachProductName = response.path("products[" +i+"].name");
            System.out.println("Product Name: "+eachProductName);

            int eachProductId = response.path("products["+i+"].id");
            System.out.println("Product ID: " + eachProductId);

        }
        System.out.println("------------------------------------------------");
        response.prettyPrint();




    }


}
