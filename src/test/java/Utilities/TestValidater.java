package Utilities;

import ExtentReports.ExtentListners;
import com.google.gson.JsonObject;
import org.json.JSONObject;

public class TestValidater {

    public static boolean getJsonkey(String json,String key)
    {
        JSONObject jsonObject=new JSONObject(json);
        ExtentListners.testReport.get().info(key.toString());
        return jsonObject.has(key);

    }
    public static String getJsonkeyValue(String json,String key)
    {
        JSONObject jsonObject=new JSONObject(json);
        return jsonObject.get(key).toString();

    }
}
