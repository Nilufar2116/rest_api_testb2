package ucodeacademy.com.day_03_path_jsonpath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import ucodeacademy.com.day_02_path_query_.GenerateToken;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class GetAllContacts {

    private static String token;

    @BeforeClass
    public static void setUp(){
        baseURI = "https://thinking-tester-contact-list.herokuapp.com/";
        token = GenerateToken.loginToGetToken();

    }

    @Test
    public void getAllContacts(){
        Response response = given().auth().oauth2(token)
                .accept(ContentType.JSON).when()
                .get("/contacts");

        response.prettyPrint();


        int contactSize = response.path("size()");
        System.out.println( "Total Contacts: "+ contactSize);
        //String firstName = response.path("[1].firstName");


        //loop and print each ID, FirstName, & LastName
        for (int i = 0; i < contactSize; i++) {
            String id = response.path("["+i+"]._id");
            System.out.println(id);

            String firstName = response.path("["+i+"].firstName");
            System.out.println(firstName);

            String lastName = response.path("["+i+"].lastName");
            System.out.println(lastName);

            System.out.println("--------------------------------------------");

        }
    }




}
