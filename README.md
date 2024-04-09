# Project Title: Movie Management Service

## Description 
This project focuses on building a web service and client to handle movie and actor data management. Key features include adding movies and actors, linking them together, and retrieving information based on titles or actor names. The client integrates with the OMDB API to provide movie rankings, enhancing the user experience with enriched data.

## Team Member
name:Yige YANG   e-mail:yygolivia@gmail.com

## Introduction
This project aims to provide a comprehensive movie management service, enabling users to add movies and actors, link actors to movies, and retrieve detailed information about movies or actors. Built with Java and utilizing RESTful web services, it serves both as a data repository and an interface to the OMDB API for movie rankings. The project is structured into two main components: the server-side services and the client application.

## Services Description
Our service layer, deployed on a web server, offers several key functionalities:
- **Add Movies**: Allows the insertion of new movies into the system with details such as title and release year.
- **Add Actors**: Permits the addition of actors, storing their names and related information.
- **Link Movies to Actors**: Facilitates the association between movies and actors, establishing a many-to-many relationship.
- **Retrieve Movie Information**: Provides movie details by title, including linked actors.
- **Retrieve Actor Information**: Offers information on actors, including the movies they've appeared in.

## Clients Description
The client application is designed to interact with our service layer, utilizing the functionalities provided to manage movies and actors. Additionally, it integrates with the OMDB API to fetch and display ratings for movies. Key operations include:
- **Adding, linking, and retrieving movies/actors**: Through user input, movies and actors can be added or linked, and their information retrieved.
- **Fetching movie ratings**: Connects to the OMDB API to display ratings for specified movies.

## Use Case
**Scenario**: Adding a Movie and Retrieving Its Rating
1. A user adds a movie "Inception" with its release year through the client application.
2. The user then adds "Leonardo DiCaprio" as an actor and links him to "Inception".
3. The user requests the details of "Inception", including its cast and OMDB rating.
4. The client application displays the movie details, including the cast and its ratings from the OMDB API.

## Source Code
The source code is structured into several packages, each serving a specific purpose within the project. Comprehensive comments are included throughout the code to explain the functionality and purpose of each class and method.
