package ucodeacademy.com.day_04_path_jsonpath_jackson;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import ucodeacademy.utility.FruitShopUtil;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Serialization extends FruitShopUtil {

    @Test
    public void getAllProducts(){
        Response response = given().contentType(ContentType.JSON)
                .when()
                .get("/products");

        //This is how we do without using Jackson Library
        List<Map<String, Object>> all = response.path("products");
        System.out.println(all);

    }


}
