package Stripetests;

import Base.BaseTest;
import BusinessLogic.CreateCustomer;
import BusinessLogic.UpdateCustomer;
import Utilities.DataUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Hashtable;

public class UpdateCustomerTest extends BaseTest {

    @Test(dataProviderClass = DataUtil.class,dataProvider = "gettestcasesdata")
    public void updateCustomers(Hashtable<String,String> data)
    {
        Response response= UpdateCustomer.updateCustomers(data);
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(),200);

    }




}
