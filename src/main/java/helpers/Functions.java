package helpers;

import classes.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static adapters.ApiClient.getAPIContent;
import static java.lang.System.exit;

public class Functions {

    public static Response validateResponse(Response response) throws Exception {
        if(response.getResponse().equals("False")){
            if (response.getError().equals("Too many results.")){
                System.out.println(response.getError() + " Please be more specific with the name.\n");
                menu();
            } else if (response.getError().equals("Movie not found!")) {
                System.out.println(response.getError() + " Please enter another movie name.\n");
                menu();
            }
        } else {
            return response;
        }
        return response;
    }

    public static String getValidatedMovieName(){

        Scanner scanner = new Scanner(System.in);

        String name = "";

        //Get Name
        while(name.length() == 0){
            System.out.println("Enter a movie or series name: ");
            name = scanner.nextLine();
            if(name.length() == 0){
                System.out.println("You must enter a movie or series name.");
            }
        }
        return name;
    }

    public static List<Media> sortMedia(List<Media> unsortedMedia){

        Comparator<Media> ratingComparator = Comparator.comparing(Media::getImdbRating).reversed();
        unsortedMedia.sort(ratingComparator);

        return unsortedMedia;
    }

    public static Media getMediaExtraInfo(String id) throws IOException {

        String pid = "&i="+id;

        String PARAMS = pid;

        String content = getAPIContent(PARAMS);

        ObjectMapper objectMapper = new ObjectMapper();

        Media media = objectMapper.readValue(content, Media.class);

        return media;
    }

    public static void getMoreInfoAboutMedia(List<Media> sortedMediaList, String type, String year) throws Exception {
        Integer listSize = sortedMediaList.size();
        String idx = "0";

        try{
            //Get media index
            Scanner scanner = new Scanner(System.in);
            while(Integer.parseInt(idx) <= 0 || Integer.parseInt(idx) > listSize){
                System.out.println("Enter the number of the movie you want to get more info: (number between 1 and "+listSize+")" );
                idx = scanner.nextLine();
                if(Integer.parseInt(idx) <= 0 || Integer.parseInt(idx) > listSize) {
                    System.out.println("It's wrong. You must enter a number between 1 and " + listSize);
                }
            }

            String pid = sortedMediaList.get(Integer.parseInt(idx)-1).getImdbID();

            // Show the complete info about the movie selected.
            SearchOne(pid, type, year);
        }catch (Exception e){
            System.out.println("It's wrong. You must enter a number between 1 and " + listSize);
        }
    }

    public static void searchMovies() throws Exception {

        Scanner scanner = new Scanner(System.in);

        String name = getValidatedMovieName();

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

            ObjectMapper objectMapper = new ObjectMapper();
            Response response = validateResponse(objectMapper.readValue(content, Response.class));

            List<Media> unsortedMediaList = new ArrayList<Media>();

            for (Search s: response.getSearch()) {
                unsortedMediaList.add(getMediaExtraInfo(s.getImdbID()));
            }

            List<Media> sortedMediaList = sortMedia(unsortedMediaList);

            Integer index = 0;
            System.out.println("Results: ");
            for (Media m: sortedMediaList) {
                ++index;
                System.out.println("--------");
                System.out.println("Result "+index+":");
                System.out.println("  Title: " + m.getTitle());
                System.out.println("  Rating: " + m.getImdbRating());
                System.out.println("  Plot: " + m.getPlot());
                System.out.println("  Genre: " + m.getGenre());
                System.out.println("  Type: " + m.getType());
                System.out.println("  Year: " + m.getYear());
            }

            // Get more information about a movie or series
            getMoreInfoAboutMedia(sortedMediaList, type, year);

    }


    public static void SearchOne(String id, String type, String year) throws Exception {
        String pid = "&i="+id;
        String ptype = "&type="+type;
        String pyear = "&y="+year;

        String PARAMS = pid + (type.isEmpty() ? ' ' : ptype ) + (year.isEmpty() ? ' ' : pyear );

        try{
            String content = getAPIContent(PARAMS);

            ObjectMapper objectMapper = new ObjectMapper();

            Media media = objectMapper.readValue(content, Media.class);

            String output = "";
            output += "Title: " + media.getTitle() + "\n";
            output += "Year: " + media.getYear() + "\n";
            output += "Rated: " + media.getRated() + "\n";
            output += "Released: " + media.getReleased() + "\n";
            output += "Runtime: " + media.getRuntime() + "\n";
            output += "Genre: " + media.getGenre() + "\n";
            output += "Director: " + media.getDirector() + "\n";
            output += "Writer: " + media.getWriter() + "\n";
            output += "Actors: " + media.getActors() + "\n";
            output += "Plot: " + media.getPlot() + "\n";
            output += "Language: " + media.getLanguage() + "\n";
            output += "Country: " + media.getCountry() + "\n";
            output += "Awards: " + media.getAwards() + "\n";
            output += "Poster: " + media.getPoster() + "\n";
            output += "Ratings: \n";
            for (Rating r: media.getRatings()) {
                output += r.getSource() + "\n";
                output += r.getValue() + "\n";
            }
            output += "Metascore: " + media.getMetascore() + "\n";
            output += "imdbRating: " + media.getImdbRating() + "\n";
            output += "imdbVotes: " + media.getImdbVotes() + "\n";
            output += "imdbID: " + media.getImdbID() + "\n";
            output += "Type: " + media.getType() + "\n";

            if (media.getType().toString().equals("movie")){
                output += "DVD: " + media.getDVD() + "\n";
                output += "BoxOffice: " + media.getBoxOffice() + "\n";
                output += "Production: " + media.getProduction() + "\n";
                output += "Website: " + media.getWebsite() + "";
            } else if (media.getType().toString().equals("series")) {
                output += "totalSeasons: " + media.getTotalSeasons() + "";
            }

            System.out.println(output);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void searchByRange() throws IOException {

        Scanner scanner = new Scanner(System.in);

        String name = getValidatedMovieName();

        //Get Start Year
        Integer yearStart = 0;
        while(yearStart <= 1900 || yearStart > 2024){
            try{
                System.out.println("Enter the Start Year you are looking for: (between 1900 and 2023)");
                yearStart = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("It's wrong. You must enter a number between 1900 and 2023");
            }
        }

        //Get End Year
        Integer yearEnd = 0;
        while(yearEnd <= 1900 || yearEnd > 2024 || yearEnd <= yearStart){
            try{
                System.out.println("Enter the End Year you are looking for (between 1900 and 2023) and higher than Start Year:");
                yearEnd = Integer.parseInt(scanner.nextLine());
                if (yearEnd <= yearStart){
                    System.out.println("The End Year must be higher than Start Year");
                }
            }catch (Exception e){
                System.out.println("It's wrong. You must enter a number between 1900 and 2023 and higher than Start Year.");
            }
        }


        // URL Compose
        String pname = "&s="+name;

        for (int year = yearStart; year <= yearEnd; year++) {

            String pyear = "&y="+year;

            String PARAMS = pname + pyear;

            String content = getAPIContent(PARAMS);

            try{
                ObjectMapper objectMapper = new ObjectMapper();

                Response response = validateResponse(objectMapper.readValue(content, Response.class));

                Integer index = 0;
                System.out.println("Results from year "+ year + ":");
                for (Search s: response.getSearch()) {
                    ++index;
                    System.out.println(index+". Title: " + s.getTitle() + " - Year: " + s.getYear());
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void menu() throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------- OMDB MOVIES SEARCH APP MENU --------------");
        System.out.println("Enter the number of the option you want:");
        System.out.println("1. Search movie or series by name, type or year.");
        System.out.println("2. Search movie or series by name and year range.");
        System.out.println("0. Exit app.");
        System.out.println("---------------------------------------------------------");
        String option = scanner.nextLine();

        switch (option) {
            case "1":
                searchMovies();
                break;
            case "2":
                searchByRange();
                break;
            case "0":
                System.out.println("Thanks for using OMDB Movies Search App.");
                exit(0);
                break;
            default:
                System.out.println("No option selected, please select one.\n");
                menu();
                break;
        }

    }

}
