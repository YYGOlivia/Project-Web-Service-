# Project Title: Movie Management Service

## Description    
This project aims to develop a web service and client for managing movie and actor data. It involves creating services that allow for adding movies, adding actors, linking movies to actors, and retrieving information based on movie titles or actor names. Additionally, the client interacts with the OMDB API to provide movie rankings, enriching the information available to end-users. This system utilizes RESTful web services for efficient data management and integration with third-party APIs.

## This system utilizes both SOAP and REST methods for implementation


## Team Member
name: Yige YANG   
e-mail: yygolivia@gmail.com

## Introduction
This project aims to provide a comprehensive movie management service, enabling users to add movies and actors, link actors to movies, and retrieve detailed information about movies or actors. Built with Java and utilizing RESTful web services, it serves both as a data repository and an interface to the OMDB API for movie rankings. The project is structured into two main components: the server-side services and the client application.

## Services Description
My service layer, deployed on a web server, offers several key functionalities:
- **Add Movies**: Allows the insertion of new movies into the system with details such as title and release year.
- **Add Actors**: Permits the addition of actors, storing their names and related information.
- **Link Movies to Actors**: Facilitates the association between movies and actors, establishing a many-to-many relationship.
- **Retrieve Movie Information**: Provides movie details by title, including linked actors.
- **Retrieve Actor Information**: Offers information on actors, including the movies they've appeared in.

## Clients Description
The client application is designed to interact with our service layer, utilizing the functionalities provided to manage movies and actors. Additionally, it integrates with the OMDB API to fetch and display ratings for movies. Key operations include:
- **Adding, linking, and retrieving movies/actors**: Through user input, movies and actors can be added or linked, and their information retrieved.
- **Fetching movie ratings**: Connects to the OMDB API to display ratings for specified movies.

##  Use Case
**Scenario**: Adding Movies and an Actor, Linking Them, and Retrieving Movie Ratings

1. **Adding Movies**: The user starts by adding two movies through the client application:
   - The first movie, "Inception" (2010), is added, generating a unique movie ID (e.g., ID: 1) upon successful addition.
   - The second movie, "Titanic" (1997), is subsequently added, receiving another unique movie ID (e.g., ID: 2).

2. **Adding an Actor**: After adding the movies, the user adds "Leonardo DiCaprio" as an actor. This action assigns a unique actor ID (e.g., ID: 1) to Leonardo DiCaprio.

3. **Linking Actor to Movies**:
   - The user then links "Leonardo DiCaprio" to "Inception" using their respective IDs (Actor ID: 1 to Movie ID: 1).
   - Following that, the same actor, "Leonardo DiCaprio", is linked to "Titanic" (Actor ID: 1 to Movie ID: 2).
   - This establishes a relationship where one actor is associated with multiple movies.

4. **Retrieving and Displaying Movie Details**:
   - The user requests details for "Inception", including its cast and OMDB rating. The client application fetches this information, displaying the movie title, year, cast (highlighting Leonardo DiCaprio's involvement), and its ratings as fetched from the OMDB API (e.g., "Rated: PG-13", "IMDb Rating: 8.8/10").
   - Similarly, the user requests details for "Titanic". The application again provides comprehensive information, including the movie's cast, showing Leonardo DiCaprio as part of it, and ratings from the OMDB API (e.g., "Rated: PG-13", "IMDb Rating: 7.9/10").

5. **Use Case Outcome**: This detailed scenario showcases the application's capabilities in managing movie and actor data, establishing relationships between them, and integrating external API data (OMDB ratings) to enrich the information provided to the user.


## Source Code
The source code is structured into several packages, each serving a specific purpose within the project. Comprehensive comments are included throughout the code to explain the functionality and purpose of each class and method.
