package ucodeacademy.com.day_04_path_jsonpath_jackson;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import ucodeacademy.utility.ContactsUtil;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestWithTokenExtractWithJsonPth extends ContactsUtil {
    String token = generateToken("amazing12@tech.com", "admin123");

    @Test
    public void sendRequestWithToken(){

        Response response = given().auth().oauth2(token)
                .contentType(ContentType.JSON)
                .when()
                .get("/contacts");

        response.then().assertThat().statusCode(200);

        JsonPath jsonPath = response.jsonPath();
        //get contact id
        String id1 = jsonPath.getString("[3]._id");
        System.out.println(id1);

        System.out.println("---------------------------------------------------");


        //get all contact ids as List
        List<String> allIds = jsonPath.getList("_id");
        System.out.println("All IDs:" +allIds);
        System.out.println("------------------------------------------------");

        //get all first name
        List<String > firstName = jsonPath.getList("firstName");
        System.out.println(firstName);
        System.out.println("--------------------------------------------------");

        //get all lastNames
        List<String> lastNames = jsonPath.getList("lastName");
        System.out.println(lastNames);

        //get all contact as List of Map
        List<Map<String, Object>> allContacts = jsonPath.getList("");
        System.out.println(allContacts);

        System.out.println("---------------------------------------------");
        List<Map<String, Object>> all = response.as(List.class);
        System.out.println(all);

        //response.prettyPrint();



    }
}
