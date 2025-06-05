package Util;

import Model.MazePoint;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ApiFetcher {
    // TODO:
    //  - Handles all HTTP requests.
    //  - Sends GET request to the API endpoint with optional width and height.
    //  - Parses the JSON response into a list of MazePoint.

    private static final String BASE_URL = "https://app.seker.live/fm1/get-points";

    /**
     * Fetches maze points from the API.
     *
     * @param width  The width of the maze (default is 30 if out of range).
     * @param height The height of the maze (default is 30 if out of range).
     * @return A list of MazePoint objects representing the maze points.
     */
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
