package Util;

import Model.MazePoint;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApiFetcher {
    // TODO:
    //  - Handles all HTTP requests.
    //  - Sends GET request to the API endpoint with optional width and height.
    //  - Parses the JSON response into a list of MazePoint.

    private static final String BASE_URL = "https://app.seker.live/fm1/get-points";

    public static List<MazePoint> fetchMazePoints(int width, int height) {
        try {
            if (width < 5 || width > 100) width = 30;
            if (height < 5 || height > 100) height = 30;

            String urlString = BASE_URL + "?width=" + width + "&height=" + height;

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(urlString)
                    .build();

            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();

            JSONArray jsonArray = new JSONArray(responseBody);
            List<MazePoint> points = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                int x = obj.getInt("x");
                int y = obj.getInt("y");
                boolean white = obj.getBoolean("white");

                points.add(new MazePoint(x,y,white));
            }

            return points;

        } catch (Exception e) {
            System.err.println("Error fetching maze: " + e.getMessage());
            return null;
        }
    }
}
