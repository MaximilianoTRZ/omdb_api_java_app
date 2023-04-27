package helpers;

import classes.*;

import classes.Error;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Scanner;

import static adapters.ApiClient.getAPIContent;

public class Functions {


    public static void SearchMovies() throws Exception {

        Scanner scanner = new Scanner(System.in);

        //Get Name
        System.out.println("Enter a movie or series name: ");
        String name = scanner.nextLine();

        // Get Type
        System.out.println("Enter the number of the type or leave empty and press enter: (optional)");
        System.out.println("1. Movie");
        System.out.println("2. Series");
        String type = scanner.nextLine();
        switch (type) {
            case "1":
                type = "movie";
                break;
            case "2":
                type = "series";
                break;
            default:
                type = "";
        }

        //Get Year
        System.out.println("Enter the year or leave empty and press enter: (optional)");
        String year = scanner.nextLine();

        // URL Compose
        String pname = "&s="+name;
        String ptype = "&type="+type;
        String pyear = "&y="+year;

        String PARAMS = pname + (type.isEmpty() ? ' ' : ptype ) + (year.isEmpty() ? ' ' : pyear );

        // API Call
        String content = getAPIContent(PARAMS);

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            Response response = objectMapper.readValue(content, Response.class);

            Integer index = 0;
            System.out.println("Results: ");
            for (Search s: response.getSearch()) {
                ++index;
                System.out.println("--------");
                System.out.println("Result "+index+":");
                System.out.println("  Title: " + s.getTitle());
                System.out.println("  ID ImdbPlot: " + s.getImdbID());
                System.out.println("  Type: " + s.getType());
                System.out.println("  Year: " + s.getYear());
            }

            // Get more information about a movie or series
            try {
                System.out.println("Enter the number of the movie you want to get more info: ");
                String idx = scanner.nextLine();
                String pid = response.getSearch().get(Integer.parseInt(idx)-1).getImdbID();

                // Show the complete info about the movie selected.
//                SearchOne();

            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        } catch (Exception e){
//            ObjectMapper objectMapper = new ObjectMapper();
//            Error error = objectMapper.readValue(content.toString(), Error.class);
//            System.out.println(error.getError());
            System.out.println(e.getMessage());
        }
    }

    public static void SearchOne() {
        //code
    }

    public static void SearchByRange() {
        //code
    }
    public static void menu() throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------- MOVIE & SERIES MENU --------------");
        System.out.println("Enter the number of the option you want:");
        System.out.println("1. Search movie or series by name, type or year.");
        System.out.println("2. Search movie or series by name and year range.");
        String option = scanner.nextLine();

        switch (option) {
            case "1":
                SearchMovies();
                break;
            case "2":
//                SearchByRange();
                break;
            default:
                // some code
        }

    }

}
