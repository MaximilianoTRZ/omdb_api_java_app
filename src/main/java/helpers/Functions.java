package helpers;

import classes.*;

import classes.Error;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

import static adapters.ApiClient.getAPIContent;

public class Functions {

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
            try {
                System.out.println("Enter the number of the movie you want to get more info: ");
                String idx = scanner.nextLine();
                String pid = response.getSearch().get(Integer.parseInt(idx)-1).getImdbID();

                // Show the complete info about the movie selected.
                SearchOne(pid, type, year);

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

    public static void SearchOne(String id, String type, String year) throws Exception {
        String pid = "&i="+id;
        String ptype = "&type="+type;
        String pyear = "&y="+year;

        String PARAMS = pid + (type.isEmpty() ? ' ' : ptype ) + (year.isEmpty() ? ' ' : pyear );

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
    }

    public static void SearchByRange() throws IOException {
        Scanner scanner = new Scanner(System.in);

        //Get Name
        System.out.println("Enter a movie or series name: ");
        String name = scanner.nextLine();
        //Get Year Since
        System.out.println("Enter the year since you are looking for:");
        Integer yearSince = Integer.parseInt(scanner.nextLine());
        //Get Year To
        System.out.println("Enter the year to you are looking for:");
        Integer yearTo = Integer.parseInt(scanner.nextLine());


        // URL Compose
        String pname = "&s="+name;

        for (int year = yearSince; year <= yearTo; year++) {

            String pyear = "&y="+year;

            String PARAMS = pname + pyear;

            String content = getAPIContent(PARAMS);

            try{
                ObjectMapper objectMapper = new ObjectMapper();

                Response response = objectMapper.readValue(content, Response.class);

                Integer index = 0;
                System.out.println("Results from year "+ year + ":");
                for (Search s: response.getSearch()) {
                    ++index;
                    System.out.println(index+". " + s.getTitle() + " - " + s.getYear());
                }
            } catch (Exception e){
                ObjectMapper objectMapper = new ObjectMapper();
                Error error = objectMapper.readValue(content.toString(), Error.class);
                System.out.println(error.getError());
//                System.out.println(e.getMessage());
                return;
            }
        }
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
                SearchByRange();
                break;
            default:
                System.out.println("No option selected.");
                break;
        }

    }

}
