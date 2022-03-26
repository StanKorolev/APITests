import io.restassured.response.Response;
import io.restassured.response.Validatable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetBookByIDTest {

    public static Response response;

    @ParameterizedTest
    @ValueSource(strings = {"5cf5805fb53e011a64671582", "5cf58077b53e011a64671583", "5cf58080b53e011a64671584"})

    public void getBooksByIDTest(String bookID) {
        response = given().get(Consts.URL + Consts.BOOKS_ENDPOINT + "/" + bookID);
        System.out.println(response.asString());
        response.then().statusCode(200);
//        check that 1 id contains 1 book
        response.then().body("total", equalTo(1));
//        check that sended id is equal to existing id
        response.then().body("docs._id", contains(bookID));
//        check that name under requested id is not null
        response.then().body("docs.name", notNullValue());
    }


}
