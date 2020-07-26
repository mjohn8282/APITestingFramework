package BusinessLogic;

import Base.BaseTest;
import io.restassured.response.Response;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;

public class UpdateCustomer extends BaseTest {

    public static Response updateCustomerTest(Hashtable<String,String>data){

        Response response=given().auth()
                .basic(config.getProperty("secretkey"),"")
                .get((config.getProperty("endpoint")+"/"+data.get("")));

        return response;
    }
}
