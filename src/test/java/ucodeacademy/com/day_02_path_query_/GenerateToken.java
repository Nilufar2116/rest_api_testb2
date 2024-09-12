package ucodeacademy.com.day_02_path_query_;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

public class GenerateToken {

    public static String endpoint = "https://thinking-tester-contact-list.herokuapp.com/users/login";

    public static String logins = """
            {
                "email": "amazing12@tech.com",
                "password": "admin123"
            }
            """;

    public static String loginToGetToken() {

        Response response = given().contentType(ContentType.JSON)
                .body(logins).when().post(endpoint);

        //get the token, store in a string variable
        String token = response.path("token");
        return token;

        //directly return the token without storing it in a variable
        //return response.path("token");

    }
        @Test
        public void getAllContacts(){
            //Generate Token
        String token = GenerateToken.loginToGetToken();

        //Response response = given().header("Authorization", "Bearer" +token)
              //  .when().get("https://thinking-tester-contact-list.herokuapp.com/contacts");

        Response response =given(). auth().oauth2(token).when()
                        .get("https://thinking-tester-contact-list.herokuapp.com/contacts");

        response.prettyPrint();
        }






}
