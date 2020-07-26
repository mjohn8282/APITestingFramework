package Base;
import Utilities.Excel;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.awt.geom.RectangularShape;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {


    public static Properties config = new Properties();
    private FileInputStream fis;
    public static Excel exceldata;


    @BeforeSuite
    public void setup() throws IOException {

        fis = new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");
        config.load(fis);

        System.out.println("In beforeSuit");
        RestAssured.baseURI = config.getProperty("Baseuri");
        RestAssured.basePath=config.getProperty("basepath");

        exceldata=new Excel(config.getProperty("ExcelData"));


    }

    @AfterSuite
    public void teardown() {
        System.out.println("In AfterSuit");
    }
}
