package ExtentReports;

import Utilities.GenericMail;
import Utilities.MailConfig;
import Utilities.SendMail;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.*;

import javax.mail.MessagingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;

public class ExtentListners implements ITestListener, ISuiteListener{

    static Date d = new Date();
    static  String messagebody;
    static String Filname = "Extent" + d.toString().replace(":", "-").replace(" ", "-") + ".html";
    private static ExtentReports extent = ExtentManager.CreateInstance(System.getProperty("user.dir") + "\\reports\\" + Filname);

    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();


    @Override
    public void onStart(ISuite suite) {



    }

    @Override
    public void onFinish(ISuite suite) {

        try {
            messagebody="http://"+ InetAddress.getLocalHost().getHostAddress()+":8080/job/APITestingFramework/HTML_20Report/"+Filname;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            SendMail.sendmails(messagebody);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    public void onTestStart(ITestResult result) {

        ExtentTest test = extent.createTest(result.getTestClass().getName() + "     @TestCase : " + result.getMethod().getMethodName());
        testReport.set(test);

    }

    public void onTestSuccess(ITestResult result) {

        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        testReport.get().pass(m);


    }

    public void onTestFailure(ITestResult result) {

        String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
        testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
                + "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>" + " \n");
        String failureLogg = "TEST CASE FAILED";
        Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
        testReport.get().log(Status.FAIL, m);

    }

    public void onTestSkipped(ITestResult result) {

        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        testReport.get().skip(m);

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

        if (extent != null) {

            extent.flush();
        }

    }
}
