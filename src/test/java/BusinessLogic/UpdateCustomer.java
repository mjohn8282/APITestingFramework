package BusinessLogic;

import Base.BaseTest;
import io.restassured.response.Response;


import java.util.Hashtable;

import static io.restassured.RestAssured.given;

public class UpdateCustomer extends BaseTest {

    public static Response updateCustomers(Hashtable<String,String>data){

        System.out.println(config.getProperty("endpoint")+"/"+data.get("ID"));
        Response response = given().auth()
                .basic(config.getProperty("secretkey"),
                        "").formParam("email", data.get("Email")).formParam("name", data.get("Name")).
                        log().all().post(config.getProperty("endpoint")+"/"+data.get("ID"));

        return response;
    }
}
