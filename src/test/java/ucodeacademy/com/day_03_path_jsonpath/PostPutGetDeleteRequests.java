package ucodeacademy.com.day_03_path_jsonpath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostPutGetDeleteRequests {

    @BeforeClass
    public static void setUp(){
        baseURI = "https://fruitshop2-predic8.azurewebsites.net/shop/v2";
    }

    int productId;


    @Test
    public void AddUpdateReadDeleteProduct(){

        File productBody = new File("product.json");

        //Add a new product
        Response postResponse = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).body(productBody)
                .when().post("/products");

        //verify status code
        postResponse.then().assertThat().statusCode(201);

        //print the response body
        postResponse.prettyPrint();

        productId = postResponse.path("id");

        //2. Get the newly added product by its ID
        Response getResponse = given().accept(ContentType.JSON)
                //.pathParams("id", productId)
                .when()
                //.get("/products/{id}");
                .get("/products/" +productId);


        //verify status code with Built-in assertion
        getResponse.then().assertThat().statusCode(200);

        //verify with JUnit
        Assert.assertEquals(200,getResponse.getStatusCode());

        getResponse.prettyPrint();

        System.out.println("--------------------------------------------");

        //3. Update the newly added product

        File putBody = new File("product2.json");

        Response putResponse = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).body(putBody)
                .when().put("/products/" +productId);

        //verify status code
        putResponse.then().assertThat().statusCode(200);

        putResponse.prettyPrint();
        System.out.println("--------------------------------------------------");

        //4 Partially update newly updated product
        String partialBody = """
                {
                
                  "price": 8.79
                }
                """;

        Response patchResponse = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).body(partialBody)
                .when().patch("/products/"+ productId);

        //verify status code
        patchResponse.then().assertThat().statusCode(200);

        patchResponse.prettyPrint();

        System.out.println("-------------------------------------------");

        //5 Delete the product
        Response deleteResponse = given().accept(ContentType.JSON)
        .when().delete("/products/"+productId);

        deleteResponse.then().assertThat().statusCode(200);

        Assert.assertEquals("Deleted",deleteResponse.path("success"));

        //print the response
        deleteResponse.prettyPrint();


        given().accept(ContentType.JSON)
                .when().get("/product/"+productId)
                .then().assertThat().statusCode(404)
                .log().body();


    }


}
