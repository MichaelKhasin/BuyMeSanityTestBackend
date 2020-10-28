import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import java.io.IOException;

/**
 * This class is REST API test, which parses json: https://4eflmsetlf.execute-api.us-east-1.amazonaws.com/default/getRandom
 * json's values are random and used for indexes of amount, region, category and gift amount in buyme.co.il site
 */

public class RestApiTest {
    public static int amount_index, region_index, category_index;
    public static String gift_amount;

    @Test
    public static void get_values() throws IOException {
        // use OKHttp client to create the connection and retrieve data
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://4eflmsetlf.execute-api.us-east-1.amazonaws.com/default/getRandom")
                .build();
        Response response = client.newCall(request).execute();
        String jsonData = response.body().string();
        //parse JSON
        JSONObject mainJsonObject = new JSONObject(jsonData);
        amount_index = mainJsonObject.getInt("amount_index");
        region_index = mainJsonObject.getInt("region_index");
        category_index = mainJsonObject.getInt("category_index");
        gift_amount = mainJsonObject.getString("gift_amount");

    }
}
