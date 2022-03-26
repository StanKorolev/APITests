import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;


public class AllBooksEndpointTest {

    public static Response response;

    @BeforeAll
    public static void setup() {
        response = given().get(Consts.URL + Consts.BOOKS_ENDPOINT);
        System.out.println(response.asString());
    }

    @Test
    public void getAllBooksResponseCodeTest() {
//        type of assertion with expecting code response
        response.then().statusCode(200);
    }

    //    Check amount of result that was return by endpoint
    @Test
    public void getAllBooksNumOfResultTest() {
        //        check that any number is presented
        response.then().body("total", notNullValue());
        //        check that number is >0
        response.then().body("total", greaterThan(0));
        //        check specific amount
        response.then().body("total", equalTo(3));
    }

    @Test
    public void getAllBooksResultHasItemsTest() {
//        check in Postman earache of JSON to see what is under what
        response.then().body("docs._id", notNullValue());
//        check specific id or name is exist
        response.then().body("docs._id", hasItem("5cf58077b53e011a64671583"));
        response.then().body("docs.name", hasItem("The Two Towers"));
//        check many results at the same moment using plural form of request hasItems, end pint can might contains more but we check only what we included
        response.then().body("docs.name", hasItems("The Two Towers", "The Fellowship Of The Ring", "The Return Of The King"));
    }

    @Test
    public void getAllBooksResultContainsTest() {
//        check full amount IN ORDER of JSON under name, has to include all existing names
        response.then().body("docs.name", contains("The Fellowship Of The Ring", "The Two Towers" , "The Return Of The King"));
//        check full amount ANY ORDER of JSON under name, has to include all existing names
        response.then().body("docs.name", containsInAnyOrder("The Fellowship Of The Ring", "The Two Towers" , "The Return Of The King"));

    }
//small performance test
    @Test
    public void getAllBooksPerformanceTest(){
//        add l letter to describe the value number is LONG integer
        response.then().time(lessThan(2000l));
    }


}