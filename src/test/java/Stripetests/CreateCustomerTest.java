package Stripetests;

import Base.BaseTest;
import BusinessLogic.CreateCustomer;
import Utilities.DataUtil;
import Utilities.TestValidater;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Hashtable;

import static io.restassured.RestAssured.*;


public class CreateCustomerTest extends BaseTest {

    @Test(dataProviderClass =DataUtil.class,dataProvider= "gettestcasesdata")
    public void ValidUsers(Hashtable<String,String> data)
    {
        Response response= CreateCustomer.validcustomer(data);
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(),200);

    }

    @Test(dataProviderClass =DataUtil.class,dataProvider= "gettestcasesdata")
    public void Invalidusers(Hashtable<String,String> data)
    {
        Response response= CreateCustomer.validcustomer(data);
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(),200);
    }




}
