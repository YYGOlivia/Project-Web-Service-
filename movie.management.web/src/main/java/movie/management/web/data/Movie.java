package movie.management.web.data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents a movie in the movie management system.
 */
@XmlRootElement
public class Movie {
    private String title; // The title of the movie
    private Integer year; // The release year of the movie
    private Integer id;   // The ID of the movie

    /**
     * Default constructor for Movie class.
     */
    public Movie() {}

    /**
     * Parameterized constructor for Movie class.
     * @param title The title of the movie.
     * @param year The release year of the movie.
     * @param id The ID of the movie.
     */
    public Movie(String title, Integer year, Integer id) {
        this.title = title;
        this.year = year;
        this.id = id;
    }
     
    /**
     * Constructor for Movie class with only title.
     * @param title The title of the movie.
     */
    public Movie(String title) {
        this.title = title;
        this.id = null;
        this.year = null;
    }
    
    /**
     * Get the title of the movie.
     * @return The title of the movie.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the movie.
     * @param title The title of the movie.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the release year of the movie.
     * @return The release year of the movie.
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Set the release year of the movie.
     * @param year The release year of the movie.
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Get the ID of the movie.
     * @return The ID of the movie.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the ID of the movie.
     * @param id The ID of the movie.
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Returns a string representation of the movie.
     * @return A string representation containing movie ID, title, and year.
     */
    @Override
    public String toString(){
        return id + "::" + title + "::" + year;
    }
}
