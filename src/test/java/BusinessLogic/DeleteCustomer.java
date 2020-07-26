package BusinessLogic;

import Base.BaseTest;
import io.restassured.response.Response;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;

public class DeleteCustomer extends BaseTest {

    public static Response deletecustomerbyID(Hashtable<String,String> data){

        System.out.println(config.getProperty("endpoint")+"/"+data.get("ID"));

        Response response=given().auth()
                .basic(config.getProperty("secretkey"),
                        "").delete((config.getProperty("endpoint")+"/"+data.get("ID")));


        return response;

    }



}
