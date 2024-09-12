package ucodeacademy.day_04_path_jsonpath_jackson;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.Test;
import ucodeacademy.utility.FruitShopUtil;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ExtractDataUsingJsonPath extends FruitShopUtil {

    @Test
    public void getAllProducts(){
        Response response = given().contentType(ContentType.JSON)
                .when()
                .get("/products");

        //verify status code with JUnit assertion
        response.then().assertThat().statusCode(200);

        //one way to create an instance/object of JsonPath
        JsonPath jsonPath = response.jsonPath();

        //second/another way to call jsonPath() and call other method
        //it is better to follow the 1st way
        //int id = response.jsonPath().getInt("products[0].id");

        //get product id using jsonPath()
        int productId = jsonPath.getInt("products[2].id");
        System.out.println("Product id: " + productId);

        System.out.println("---------------------------------------------");

        //get product name using jsonPath()
        String productName = jsonPath.getString("products[2].name");
        System.out.println("Product Name: " +productName);
        System.out.println("---------------------------------------------------");

        //get all product ids as List (Collection)
        List<Integer> allIds = jsonPath.getList("products.id");
        System.out.println("All Ids: " +allIds);
        System.out.println("------------------------------------------------");

        //get all product names as List Collection
        List<String> allNames = jsonPath.getList("products.name");
        System.out.println("All names: " + allNames);

        System.out.println("-------------------------------------------");

        //get all products as list of Map
        List<Map<String, Object>> allProducts = jsonPath.getList("products");
        System.out.println("All products: " +allProducts);
        response.prettyPrint();

        //create an instance of XMLPath
        //XmlPath id2 = response.xmlPath();



    }
}
