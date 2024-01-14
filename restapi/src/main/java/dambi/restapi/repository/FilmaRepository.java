/**
 * This interface provides methods for interacting with the database table "filma".
 * 
 * @author Dambi
 *
 */
package dambi.restapi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import dambi.restapi.model.Filma;

@Repository
public interface FilmaRepository {

    /**
     * Returns a list of all films in the database.
     * 
     * @return a list of all films
     */
    List<Filma> findAll();

    /**
     * Returns a film with the specified ID.
     * 
     * @param id the ID of the film
     * @return the film with the specified ID or null if no film with the specified ID exists
     */
    Filma findFilmaById(String id);

    /**
     * Returns a list of films from the specified country.
     * 
     * @param country the country of the films
     * @return a list of films from the specified country
     */
    List<Filma> findFilmaByCountry(String country);

    /**
     * Saves a film in the database.
     * 
     * @param filma the film to save
     * @return the saved film
     */
    Filma save(Filma filma);

    /**
     * Deletes a film from the database with the specified ID.
     * 
     * @param id the ID of the film to delete
     * @return the number of films deleted
     */
    long deleteById(String id);

    /**
     * Deletes a film from the database with the specified title.
     * 
     * @param title the title of the film to delete
     * @return the number of films deleted
     */
    long deleteByTitle(String title);

}