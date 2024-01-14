package dambi.restapi.model;

/**
 * This class represents a Cast in the Movie Database.
 * 
 * @author asier
 */
public class Cast {

    private int id;
    private String firstname;
    private String surname;

    /**
     * Default constructor
     */
    public Cast() {

    }

    /**
     * Constructor with parameters
     * @param id the id of the cast
     * @param firstname the firstname of the cast
     * @param surname the surname of the cast
     */
    public Cast(int id, String firstname, String surname) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
    }

    /**
     * @return the id of the cast
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the cast
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**s
     * @return the firstname of the cast
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the firstname of the cast
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the surname of the cast
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname of the cast
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
