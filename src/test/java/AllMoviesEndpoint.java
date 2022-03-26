import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class AllMoviesEndpoint {


    public static Response response;

    @BeforeAll
    public static void setup() {
//        Add TOKEN and CONTENT TYPE (JSON) if required
        response = given().auth().oauth2(Consts.TOKEN).contentType("application/json").get(Consts.URL + Consts.MOVIES_ENDPOINT);
        System.out.println(response.asString());
    }

    @Test
    public void getAllMoviesResponseCodeTest() {
        response.then().statusCode(200);
    }

}
