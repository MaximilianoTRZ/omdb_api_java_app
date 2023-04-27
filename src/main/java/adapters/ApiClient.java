package adapters;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiClient {
    private static Dotenv dotenv = Dotenv.load();

    private static final String URL_BASE = "http://www.omdbapi.com/?apikey=";
    private static final String API_KEY = dotenv.get("API_KEY");


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
