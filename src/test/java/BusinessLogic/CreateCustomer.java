package BusinessLogic;

import Base.BaseTest;
import io.restassured.response.Response;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;

public class CreateCustomer extends BaseTest {

    public static Response validcustomer(Hashtable<String, String> data) {

        Response response = given().auth()
                .basic(config.getProperty("secretkey"),
                        "").formParam("email", data.get("Email")).formParam("name", data.get("Name")).
                        formParam("phone", data.get("Phone")).log().all().post(config.getProperty("endpoint"));

        return response;

    }

    public static Response Invalidcustomer(Hashtable<String, String> data) {

        Response response = given().auth()
                .basic(config.getProperty("secretkey"),
                        "").formParam("email", data.get("Email")).formParam("name", data.get("Name")).
                        formParam("phone", data.get("Phone")).log().all().post(config.getProperty("endpoint"));

        return response;

    }
}




