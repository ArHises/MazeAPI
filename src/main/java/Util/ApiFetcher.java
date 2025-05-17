package Util;

import Model.MazePoint;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
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
            URL url = new URL(urlString);

            InputStreamReader reader = new InputStreamReader(url.openStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            // Parse JSON array into List<MazePoint>
            return new Gson().fromJson(
                    reader,                           // the JSON input
                    new TypeToken<List<MazePoint>>() {}.getType()  // tells Gson it's a list of MazePoints
            );

        } catch (Exception e) {
            System.err.println("Error fetching maze: " + e.getMessage());
            return null;
        }
    }
}
