package apishi;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class Apitest1 {
    private final static String url = "https://restful-booker.herokuapp.com";
    @Test
    public void Check1(){
        Specifications.installSpecification(Specifications.requestSpec(url), Specifications.responseSpecOK200());
     List<UserData> users = given()
        .when()

             .get("https://restful-booker.herokuapp.com/booking")
             .then().log().all()
             .extract().body().jsonPath().getList("data", UserData.class);

    }
    @Test
    public void create(){
        Specifications.installSpecification(Specifications.requestSpec(url), Specifications.responseSpecOK200());
        int bookingid = 0;
        UserData user = new UserData("Anna", "Klo", 120, true, "2024-01-01", "2024-01-01");

            UserData userData = given()
                    .contentType(JSON)
                    .body(user)
                    .when()
        .post("https://restful-booker.herokuapp.com/booking")
                    .then().log().all()
                    .extract().as(UserData.class);
           Assert.assertNotNull(bookingid);

    }
}
