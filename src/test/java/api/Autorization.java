package api;

import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class Autorization {
    private final static String url = "https://restful-booker.herokuapp.com";

    @Test
    public void successRegTest(){
        Specifications.installSpecification(Specifications.requestSpec(url), Specifications.responseSpecOK200());
        String token = "abc123";
         Registr user = new Registr("admin", "password123");

         var json = new Gson().toJson(user);

         Successreg successreg = given()
                 .contentType(JSON)
                 .body(user)
                 .when()
                 .post("https://restful-booker.herokuapp.com/auth")
               .then().log().all()
                .extract().as(Successreg.class);
Assert.assertEquals(token, successreg.getToken());




    }


}
