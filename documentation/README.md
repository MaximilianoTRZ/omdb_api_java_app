# Classes Documentation

### ApiClient

The ApiClient class is used to make HTTP requests to the OMDB API using the provided API key. This class provides a method for getting the content from the API for the provided parameters.

### Functions

The Functions class contains various functions related to the search for movies or series using the OMDB API. Here is a brief summary of each method:

- ```validateResponse(Response response)```: This method takes a Response object, checks if it contains an error, and returns the response object if there is no error. If there is an error, it displays a message and calls the menu() method.

- ```getValidatedMovieName()```: This method prompts the user to enter a movie or series name and returns the entered name after validating it. It checks if the entered name is empty and prompts the user again to enter a name.

- ```sortMedia(List<Media> unsortedMedia)```: This method takes an unsorted list of Media objects, sorts them by descending order of IMDB rating, and returns the sorted list.

- ```getMediaExtraInfo(String id)```: This method takes an IMDB ID, uses it to fetch detailed information about a movie or series using the OMDB API, and returns a Media object containing the fetched information.

- ```getMoreInfoAboutMedia(List<Media> sortedMediaList, String type, String year)```: This method takes a sorted list of Media objects, prompts the user to enter the number of a movie or series they want to know more about, and calls the SearchOne() method with the IMDB ID of the selected movie or series.

- ```searchMovies()```: This method prompts the user to enter a movie or series name, type, and year (if applicable), uses the OMDB API to search for movies or series that match the entered criteria, and displays a sorted list of search results.

- ```SearchOne(String id, String type, String year)```: This method takes an IMDB ID, type, and year (if applicable), uses the OMDB API to fetch detailed information about a movie or series, and displays the fetched information.

- ```searchByRange()```: This function searches for movies or series by name and within a given year range. It prompts the user to enter a valid movie name and start and end years, validates the input, and then sends an API request to the OMDB API with the given parameters.

- ```menu()```: This function displays a menu with two options to the user. Option 1 searches for movies or series by name, type, or year, while option 2 searches for movies or series by name and year range. The function prompts the user to enter a valid option number and then calls the appropriate function based on the user's choice. If the user enters an invalid option number, the function displays an error message and calls itself again.


### Media

Represents movie and series information. It is annotated with "@JsonProperty" annotations, which means that the class properties are mapped to specific keys in a JSON file. Each property represents a different part of the movie or series information. Here is a list of the properties and what they represent:

- "Title": the title of the movie or series.
- "Year": the release year of the movie or series.
- "Rated": the rating of the movie or series.
- "Released": the release date of the movie or series.
- "Runtime": the duration of the movie or series.
- "Genre": the genre of the movie or series.
- "Director": the director of the movie or series.
- "Writer": the writer of the movie or series.
- "Actors": the actors in the movie or series.
- "Plot": the plot of the movie or series.
- "Language": the language of the movie or series.
- "Country": the country of the movie or series.
- "Awards": any awards the movie or series has won.
- "Poster": the URL of the poster for the movie or series.
- "Ratings": a list of ratings for the movie or series.
- "Metascore": the Metascore rating for the movie or series.
- "imdbRating": the IMDb rating for the movie or series.
- "imdbVotes": the number of votes the movie or series has on IMDb.
- "imdbID": the IMDb ID for the movie or series.
- "Type": the type of media, such as "movie" or "series".
- "DVD": the release date of the movie on DVD.
- "BoxOffice": the box office earnings for the movie.
- "Production": the production company for the movie.
- "Website": the website for the movie.
- "totalSeasons": the total number of seasons for a series.
- "Response": a boolean value indicating whether the API responded successfully.

### Rating 

Represents a rating for a movie or series. It is also annotated with "@JsonProperty" annotations. The class has two properties:

- "Source": the source of the rating.
- "Value": the actual value of the rating.

### Search

Represents the search results for a movie or series. It is annotated with "@JsonProperty" annotations. The class has five properties:

- "Title": the title of the movie or series.
- "Year": the release year of the movie or series.
- "imdbID": the IMDb ID of the movie or series.
- "Type": the type of media, such as "movie" or "series".
- "Poster": the URL of the poster for the movie or series.

### Response

Represents the response from a movie or series search. It is annotated with "@JsonProperty" annotations. The class has four properties:

- "Response": indicates whether the search was successful or not. If the value is "True", the search was successful. If the value is "False", the search failed.
- "Search": a list of search results, represented as instances of the "Search" class.
- "totalResults": the total number of search results.
- "Error": an error message, if the search failed.