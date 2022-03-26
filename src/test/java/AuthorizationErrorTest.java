import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthorizationErrorTest {


    @Test
    public void invalidTokenTest() {
//        Add TOKEN and CONTENT TYPE (JSON) if required
        Response response = given().auth().oauth2("vsokdvnklzsd;bndfb").contentType("application/json").get(Consts.URL + Consts.MOVIES_ENDPOINT);
        System.out.println(response.asString());
        response.then().statusCode(401);
        response.then().body("message", equalTo("Unauthorized."));
//        when need to find just part of the answer
        response.then().body("message", containsString("Unauthori"));


    }

}
