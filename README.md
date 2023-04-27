# OMDB Movies Search App

<img src="https://code.4noobz.net/wp-content/uploads/2018/10/OMDB-API.png">

## Features

The application has the following features:

1. Allows the user to enter a movie or series name [Required], type (movie or series) [Optional], or year [Optional] from the console and displays the obtained information of title, rating, plot, genre, type and year sorted by rating from highest to lowest.
2. From the above list, the user has the option to select the complete information of a chosen movie or TV show.
3. The user has an option to obtain movies with a specific name and range of years. As a result, it lists the found movies with their name and release year.

## How to Use the Application
To use the application, execute the JAR file and follow the instructions displayed in the console.

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
 #### Show Information
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
