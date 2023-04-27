# OMDB Movies Search App

<img src="https://code.4noobz.net/wp-content/uploads/2018/10/OMDB-API.png">

## Features

The application has the following features:

1. Allows the user to enter a movie or series name [Required], type (movie or series) [Optional], or year [Optional] from the console and displays the obtained information of title, rating, plot, genre, type and year sorted by rating from highest to lowest.
2. From the above list, the user has the option to select the complete information of a chosen movie or TV show.
3. The user has an option to obtain movies with a specific name and range of years. As a result, it lists the found movies with their name and release year.

## Requirements

- Java Development Kit (JDK) version 11 or higher should be installed on the system.
- Maven build tool version 3.3.0 or higher should be installed on the system.
- An internet connection is required to download dependencies specified in the pom.xml file from the Maven Central Repository.
- The application requires access to the OMDB API. Therefore, an API key must be obtained from http://www.omdbapi.com/ and exported as an environment variable named "API_KEY".
- Clone the source code from this repository.
- The dependencies specified in the pom.xml file must be resolved and downloaded by Maven. This can be done by navigating to the root directory of the project and executing the command ```mvn clean install``` in the terminal.
- The jar file with dependencies can be created running the command ```mvn clean compile assembly:single```

## How to Use the Application
After the dependencies are downloaded, the application can be executed by navigating to the directory containing the jar file and running the command ```java -jar <jar-file-name>```. To use the application, execute the JAR file and follow the instructions displayed in the console. Alternatively, the application can be run using the Maven command ```mvn exec:java -Dexec.mainClass=org.app.Main```.


### Options Menu
First, you will see an options menu as following:

```
-------------- MOVIE & SERIES MENU --------------
Enter the number of the option you want:
1. Search movie or series by name, type or year.
2. Search movie or series by name and year range.
```

### 1. Search movie or series by name, type or year.
To search a movie or series by name, type or year, write its name in the console. Optionally, you can specify the type (movie or series) or the year. For example:

  ```
Enter a movie or series name: 
man
  ```
  ```
Enter the number of the type or leave empty and press enter: (optional)
1. Movie
2. Series
1
  ```
  ```
Enter the year or leave empty and press enter: (optional)
2015
  ```
 #### Information displayed
The application will display the obtained information from the search in rating order, from highest to lowest. The information displayed will include the title, rating, plot, genre, type and year. For example:

  ``` 
  Results: 
--------
Result 1:
  Title: Spider-Man: No Way Home
  Rating: 8.2
  Plot: With Spider-Man's identity now revealed, Peter asks Doctor Strange for help. When a spell goes wrong, dangerous foes from other worlds start to appear, forcing Peter to discover what it truly means to be Spider-Man.
  Genre: Action, Adventure, Fantasy
  Type: movie
  Year: 2021
--------
Result 2:
  Title: Iron Man
  Rating: 7.9
  Plot: After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.
  Genre: Action, Adventure, Sci-Fi
  Type: movie
  Year: 2008
--------
Result 3:
  Title: Spider-Man
  Rating: 7.4
  Plot: After being bitten by a genetically-modified spider, a shy teenager gains spider-like abilities that he uses to fight injustice as a masked superhero and face a vengeful enemy.
  Genre: Action, Adventure, Sci-Fi
  Type: movie
  Year: 2002
--------
Result 4:
  .
  .
  .
  ```
 
### 2. Select a movie or series to get the complete information.
If you want to get the complete information of a movie or series from the displayed list, enter the corresponding number in the console. For example:
  ```
  Enter the number of the movie you want to get more info: 
  5
  ```
#### Information displayed
The application will then display all the available information about that movie or series.

```
Title: Spider-Man: No Way Home
Year: 2021
Rated: PG-13
Released: 17 Dec 2021
Runtime: 148 min
Genre: Action, Adventure, Fantasy
Director: Jon Watts
Writer: Chris McKenna, Erik Sommers, Stan Lee
Actors: Tom Holland, Zendaya, Benedict Cumberbatch
Plot: With Spider-Man's identity now revealed, Peter asks Doctor Strange for help. When a spell goes wrong, dangerous foes from other worlds start to appear, forcing Peter to discover what it truly means to be Spider-Man.
Language: English
Country: United States
Awards: Nominated for 1 Oscar. 35 wins & 69 nominations total
Poster: https://m.media-amazon.com/images/M/MV5BZWMyYzFjYTYtNTRjYi00OGExLWE2YzgtOGRmYjAxZTU3NzBiXkEyXkFqcGdeQXVyMzQ0MzA0NTM@._V1_SX300.jpg
Ratings: 
Internet Movie Database
8.2/10
Metacritic
71/100
Metascore: 71
imdbRating: 8.2
imdbVotes: 782,613
imdbID: tt10872600
Type: movie
DVD: N/A
BoxOffice: $814,115,070
Production: Columbia Pictures
Website: N/A
  ```
### 3. Get Movies by Name and Year Range
If you want to get a list of movies containing a certain name and released within a range of years, enter the name, start year, and end year in the console. For example:

```
Enter a movie or series name: 
man
Enter the start year you are looking for:
2018
Enter the end year you are looking for:
2020
```
 #### Information displayed
 
 ```
Results from year 2018:
1. Spider-Man: Into the Spider-Verse - 2018
2. Ant-Man and the Wasp - 2018
3. First Man - 2018
.
.
.
Results from year 2019:
1. Spider-Man: Far from Home - 2019
2. Gemini Man - 2019
3. The Family Man - 2019–
.
.
.
Results from year 2020:
1. The Invisible Man - 2020
2. The Empty Man - 2020
3. James May: Our Man in... - 2020–2022
.
.
.
 ```
 
 
### Dockerizing the Application

1. In the root directory of the project it is a Dockerfile that will create a new image based on the OpenJDK 11 version, install maven, set the working directory to /app, create a jar file, and execute the jar file when the container starts.

2. Build the Docker image by running the following command in the root directory of the project:
```
docker build . -t omdbapp:v1.0
```
This command will use the Dockerfile to build the image and tag it as omdbapp:v1.0.

3. Run the Docker container by executing the following command:
```
docker run --name omdbapp -it -p 8080:8080 omdbapp:v1.0
```
This command will start a new container named omdbapp, forward the port 8080 of the host to the port 8080 of the container, and use the omdbapp:v1.0 image to run the container.

### Unit Tests Documentation

#### FunctionsTest Class

- ```showsCompleteInfoAboutAMovie()```

This test verifies if the SearchOne() function returns the complete information about a particular movie. The movie ID is provided as input and the function is expected to return a formatted string containing the movie information. The expected output string contains the movie title, release year, rating, runtime, genre, director, writer, actors, plot, language, country, awards, poster, ratings, IMDB rating, IMDB votes, IMDB ID, type, DVD release date, box office, production, and website. The test uses the assertEquals() method to compare the expected output with the actual output obtained from the outputStreamCaptor.

- ```menuShowsOptions()```

This test verifies if the menu() function displays the correct menu options when executed. The expected output string contains the menu options available to the user. The test uses System.setIn() to provide input to the menu() function, simulating user input of 0. The test then uses the assertEquals() method to compare the expected output with the actual output obtained from the outputStreamCaptor.


#### APIClientTest Class

- ```apiReturnsAnStringContent()```

This test verifies that the getAPIContent method returns a string content when provided with a valid input parameter. The test first calls the getAPIContent method with the input parameter &i=tt3896198. It then asserts that the object returned is of the String class using assertEquals. If the returned object is not a String, the test will fail.

- ```apiCallBadParamsThrowsIOException```

This test verifies that the getAPIContent method throws an IOException when provided with invalid input parameters. The test calls the getAPIContent method with an invalid input parameter "exampleBadParam" using assertThrows and verifies that it throws an IOException. If the method does not throw an IOException, the test will fail.

- ```makeApiCallReturnsNotNull```

This test verifies that the getAPIContent method returns a non-null value when provided with a valid input parameter. The test first calls the getAPIContent method with the input parameter &i=tt3896198. It then asserts that the returned value is not null using assertNotNull. If the method returns a null value, the test will fail.
