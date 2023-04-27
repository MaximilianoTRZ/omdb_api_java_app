# Classes Documentation

### ApiClient class

The ApiClient class is used to make HTTP requests to the OMDB API using the provided API key. This class provides a method for getting the content from the API for the provided parameters.

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