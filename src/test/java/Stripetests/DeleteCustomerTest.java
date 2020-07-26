package Stripetests;
import Base.BaseTest;
import BusinessLogic.DeleteCustomer;
import ExtentReports.ExtentListners;
import Utilities.DataUtil;
import Utilities.TestValidater;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class DeleteCustomerTest extends BaseTest {

    @Test(dataProviderClass = DataUtil.class,dataProvider= "gettestcasesdata")
    public void deletecustomer(Hashtable<String,String> data)
    {

        Response response= DeleteCustomer.deletecustomerbyID(data);
        response.prettyPrint();
        ExtentListners.testReport.get().info(data.toString());
        Assert.assertEquals(response.statusCode(),200);
        System.out.println("presence check for ID :"+TestValidater.getJsonkey(response.asString(),"id"));
        Assert.assertTrue(TestValidater.getJsonkey(response.asString(),"id"));
        String ActualIDInAPI=TestValidater.getJsonkeyValue(response.asString(),"id");
        Assert.assertEquals(ActualIDInAPI,data.get("ID"),"Id Incorrect");


    }
}
