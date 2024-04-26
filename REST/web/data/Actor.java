package movie.management.web.data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents an actor in the movie management system.
 */
@XmlRootElement
public class Actor {
    private String name; // The name of the actor
    private Integer id; // The ID of the actor

    /**
     * Default constructor for Actor class.
     */
    public Actor() {}

    /**
     * Parameterized constructor for Actor class.
     * @param name The name of the actor.
     * @param id The ID of the actor.
     */
    public Actor(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Get the name of the actor.
     * @return The name of the actor.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the actor.
     * @param name The name of the actor.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the ID of the actor.
     * @return The ID of the actor.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the ID of the actor.
     * @param id The ID of the actor.
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Returns a string representation of the actor.
     * @return A string representation containing actor ID and name.
     */
    @Override
    public String toString(){
      return id + "::" + name;
    }
}
