import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import java.util.HashMap;

//ADD GSON to the pom file
public class CreateEmloyeTest {
    public static final String EMPLOYEE_NAME = "name";
    public static final String EMPLOYEE_AGE = "age";
    public static final String EMPLOYEE_SALARY = "salary";

    @Test
    public void createEmployeeTest() {
        Response response = given().contentType("application/json").body("{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}\t\n").post(Consts.URL_EMPLOYEES + Consts.CREATE_EMPLOYEE);
        System.out.println(response.asString());

    }

//Hash map using for create new employee
//    CHECK HAMREST DOCS you find alot of stuff there
    @Test
    public void createEmployeeHashmapTest() {
        HashMap employee = new HashMap();
        employee.put(EMPLOYEE_NAME, "sasha");
        employee.put(EMPLOYEE_SALARY, "100");
        employee.put(EMPLOYEE_AGE, "35");


        Response response = given().contentType("application/json").body(employee).post(Consts.URL_EMPLOYEES + Consts.CREATE_EMPLOYEE);
        System.out.println(response.asString());

    }
}
