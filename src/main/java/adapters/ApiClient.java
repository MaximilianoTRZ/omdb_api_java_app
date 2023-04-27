package adapters;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This class is used to make HTTP requests to the OMDB API using the provided API key.
 */

public class ApiClient {
    private static Dotenv dotenv = Dotenv.load();

    // Base URL of the OMDB API
    private static final String URL_BASE = "http://www.omdbapi.com/?apikey=";

    // API key to access the OMDB API, loaded from the API_KEY environment variable
    private static final String API_KEY = dotenv.get("API_KEY");


    /**
     * Gets the content from the OMDB API for the provided parameters.
     *
     * @param PARAMS the parameters to use in the HTTP query
     * @return the content of the OMDB API response as a string
     * @throws IOException if an error occurs while making the HTTP request
     */
    public static String getAPIContent(String PARAMS) throws IOException {

        URL url = new URL(URL_BASE + API_KEY + PARAMS);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        return content.toString();
    }

}
