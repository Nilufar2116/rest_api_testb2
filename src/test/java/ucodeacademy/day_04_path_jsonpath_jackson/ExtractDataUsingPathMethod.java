package ucodeacademy.day_04_path_jsonpath_jackson;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import ucodeacademy.utility.FruitShopUtil;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ExtractDataUsingPathMethod extends FruitShopUtil {

    @Test
    public void getAllProducts(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/products");

        //verify status code TestNG assertion
        Assert.assertEquals(200, response.getStatusCode());

        //verify status code with JUnit assertion
        response.then().assertThat().statusCode(200);

       //response.prettyPrint();

        //get product name
        String productName = response.path("products[0].name");
        System.out.println(productName);

        //get product id
        int productId= response.path("products[0].id");
        System.out.println(productId);

        //get all products ids as Collection(List)
        List<Integer> allIds = response.path("products.id");
        System.out.println("All product ids:" +allIds);

        System.out.println("----------------------------------------------------");

        //get all product names as Collection (List)
        List<String> allProductNames = response.path("products.name");
        System.out.println(allProductNames);

        System.out.println("-------------------------------------------------");

        //get all products as List of Maps
        //? mark means any kind or any type //for the value we give "Object"
        //Object java.lang is the parent class of all classes in JAVA
        List<Map<String, Object>> allProducts = response.path("products");
        System.out.println(allProducts);
        System.out.println("--------------------------------------------------");

        //(explicit casting) (int)
        int prodId = (int) allProducts.get(3).get("id");
        System.out.println(prodId);

        System.out.println("--------------------------------------------------");

        //get product name from list of Maps
        String prodName = (String)allProducts.get(2).get("name");
        System.out.println(prodName);

        System.out.println("--------------------------------------------------");

        response.prettyPrint();
    }

}
