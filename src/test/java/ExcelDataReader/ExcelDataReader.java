package ExcelDataReader;

import Base.BaseTest;
import Utilities.DataUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;


public class ExcelDataReader extends BaseTest {

   @DataProvider
    public Object[][] gettestcasesdata() {

        int rownum = exceldata.getRowCount("Testdata");
        int colcount = exceldata.getColumnCount("Testdata");

        String  testcasename = "Invalidusers";
        int testcaserownum=1;

        for (testcaserownum=1;testcaserownum<rownum;testcaserownum++)
        {
            String Exceltestcasename= exceldata.getCellData("Testdata",0,testcaserownum);
            if(Exceltestcasename.equalsIgnoreCase(testcasename))
                break;

        }


        System.out.println("Total testcaserownum   " + testcaserownum);

        //checking total rows in testcase

        int datarownum=testcaserownum+2;
        int testrow=0;
        System.out.println(exceldata.getCellData("Testdata",0,datarownum));

        while(!exceldata.getCellData("Testdata",0,datarownum+testrow).equals(""))
        {

            testrow++;

        }
        int datacolrow=testcaserownum+1;
        int testcol=0;

        while(!exceldata.getCellData("Testdata",0+testcol,datacolrow).equals("")){

            testcol++;

        }

        Object[][] data =new Object[testrow][1];

        int i=0;

        for(int rnum=datarownum;rnum<datarownum+testrow;rnum++){

            Hashtable<String,String> tabledata=new Hashtable<String, String>();

            for(int cnum=0;cnum<testcol;cnum++)
            {
                String tKey=exceldata.getCellData("Testdata",cnum,datacolrow);
                String tvalue=exceldata.getCellData("Testdata",cnum,rnum);

                tabledata.put(tKey,tvalue);
            }

            data[i][0]=tabledata;
            i++;
        }

        return data;
    }


}



