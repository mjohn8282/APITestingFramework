package Stripetests;

import Base.BaseTest;
import BusinessLogic.CreateCustomer;
import BusinessLogic.GetCustomers;
import Utilities.DataUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class GetCustomerTest extends BaseTest {


    @Test(dataProviderClass =DataUtil.class,dataProvider= "gettestcasesdata")
    public void GetCustomer(Hashtable<String,String> data)
    {
        Response response= GetCustomers.getcustomers(data);
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(),200);
    }

}
