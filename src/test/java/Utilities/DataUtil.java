package Utilities;

import Base.BaseTest;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class DataUtil extends BaseTest {


    @DataProvider(name="getdata")
    public  Object[][] getdata(Method m)
    {
        String sheetname=m.getName();

        int rowcount=exceldata.getRowCount(sheetname);
        int colcount=exceldata.getColumnCount(sheetname);

        Object[][] data=new Object[rowcount-1][colcount];

        for (int rownum=2;rownum<=rowcount;rownum++)
        {
            for(int col=0;col<colcount;col++)
            {
                data[rownum-2][col]=exceldata.getCellData(sheetname,col,rownum);
            }

        }

        return data;


    }

    @DataProvider
    public Object[][] gettestcasesdata(Method m) {

        int rownum = exceldata.getRowCount(Constants.Testdatasheet);
        int colcount = exceldata.getColumnCount(Constants.Testdatasheet);

        String  testcasename = m.getName();


        int testcaserownum=1;

        for (testcaserownum=1;testcaserownum<rownum;testcaserownum++)
        {
            String Exceltestcasename= exceldata.getCellData(Constants.Testdatasheet,0,testcaserownum);
            if(Exceltestcasename.equalsIgnoreCase(testcasename))
                break;

        }


        System.out.println("Total testcaserownum   " + testcaserownum);

        //checking total rows in testcase

        int datarownum=testcaserownum+2;
        int testrow=0;
        System.out.println(exceldata.getCellData(Constants.Testdatasheet,0,datarownum));

        while(!exceldata.getCellData(Constants.Testdatasheet,0,datarownum+testrow).equals(""))
        {

            testrow++;

        }
        int datacolrow=testcaserownum+1;
        int testcol=0;

        while(!exceldata.getCellData(Constants.Testdatasheet,0+testcol,datacolrow).equals("")){

            testcol++;

        }

        Object[][] data =new Object[testrow][1];

        int i=0;

        for(int rnum=datarownum;rnum<datarownum+testrow;rnum++){

            Hashtable<String,String> tabledata=new Hashtable<String, String>();

            for(int cnum=0;cnum<testcol;cnum++)
            {
                String tKey=exceldata.getCellData(Constants.Testdatasheet,cnum,datacolrow);
                String tvalue=exceldata.getCellData(Constants.Testdatasheet,cnum,rnum);

                tabledata.put(tKey,tvalue);
            }

            data[i][0]=tabledata;
            i++;
        }

        return data;
    }


}
