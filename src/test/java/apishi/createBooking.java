package apishi;

import com.google.gson.Gson;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class createBooking {
    private final static String url = "https://restful-booker.herokuapp.com";

    @Test
    public void createBooking(Object BookingData){

        Specifications.installSpecification(Specifications.requestSpec(url), Specifications.responseSpecOK200());
        var json1 = new Gson().toJson(BookingData);
        Object bookingid = given().body(BookingData)
                .when()
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("bookingid", notNullValue())
                .body("booking.firstname", equalTo("Vasya"))
                .body("booking.lastname", equalTo("Pupkin"))
                .body("booking.totalprice", equalTo("100"))
                .body("booking.depositpaid", equalTo("Vasya"))
                .body("booking.bookingdates.checkin", equalTo("23/06/24"))
                .body("booking.bookingdates.checkout", equalTo("26/06/24"))
                .body("booking.additionalneeds", equalTo("Lunch"))
                .extract()
                .path("bookingid");









    }
}
