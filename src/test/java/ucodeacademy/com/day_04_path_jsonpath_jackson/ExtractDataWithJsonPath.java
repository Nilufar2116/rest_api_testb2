package ucodeacademy.com.day_04_path_jsonpath_jackson;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import ucodeacademy.utility.FruitShopUtil;
import static io.restassured.RestAssured.given;

public class ExtractDataWithJsonPath extends FruitShopUtil {

    @Test
    public void testJsonPath(){
        Response response =given().contentType(ContentType.JSON)
                .when()
                .get("/products");

        Assert.assertEquals(200,response.getStatusCode());

        //create an object of jsonPath
        JsonPath jsonPath = response.jsonPath();

        int id = jsonPath.get("products[0].id");
        int id2 = jsonPath.getInt("products[0].id");

        System.out.println(id);  // control z
        System.out.println(id2);
        System.out.println("---------------------------------------------");

        String name1 = jsonPath.get("products[1].name");

        String name2 = jsonPath.getString("products[1].name");

        System.out.println(name1);
        System.out.println(name2);

    }


}
