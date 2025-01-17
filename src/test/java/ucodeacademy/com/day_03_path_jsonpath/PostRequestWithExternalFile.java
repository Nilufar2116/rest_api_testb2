package ucodeacademy.com.day_03_path_jsonpath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import ucodeacademy.com.day_02_path_query_.GenerateToken;

import java.io.File;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostRequestWithExternalFile {

    private static String token;

    File postBody = new File("contact.json");

    @BeforeClass
    public static void setUp(){
        baseURI = "https://thinking-tester-contact-list.herokuapp.com/";
        token = GenerateToken.loginToGetToken();

    }

    @Test
    public void addNewContactUsingExternalFile(){
        Response response = given().auth().oauth2(token)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(postBody).when().post("/contacts");

        response.then().assertThat().statusCode(201);
        response.prettyPrint();
    }

}
