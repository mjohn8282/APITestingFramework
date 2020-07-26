package ExtentReports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.BeforeSuite;


public class ExtentManager {

    private static ExtentReports extent;
    private static ExtentSparkReporter htmlReporter;



    public static ExtentReports CreateInstance(String Filename)
    {
        htmlReporter = new ExtentSparkReporter(Filename);


        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(Filename);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(Filename);

        extent=new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester","John Moses");
        extent.setSystemInfo("Organization","My Company");
        extent.setSystemInfo("Buil","0.1");


        return extent;



    }
}
