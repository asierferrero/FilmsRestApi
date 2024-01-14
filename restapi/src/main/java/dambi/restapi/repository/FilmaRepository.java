package dambi.restapi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import dambi.restapi.model.Filma;

/**
 * The FilmaRepository interface defines the methods that the Spring Data JPA repository will use to interact with the Filma entity.
 * The methods are defined as follows:
 * 
 * findAll: Returns a list of all Filma entities in the database.
 * findFilmaById: Returns a Filma entity based on its ID.
 * save: Saves a Filma entity to the database.
 * deleteById: Deletes a Filma entity from the database based on its ID.
 */

@Repository
public interface FilmaRepository {

    /**
     * Returns a list of all Filma entities in the database.
     * 
     * @return a list of Filma entities
     */
    List<Filma> findAll();

    /**
     * Returns a Filma entity based on its ID.
     * 
     * @param id the ID of the Filma entity
     * @return the Filma entity with the specified ID, or null if no entity with that ID exists
     */
    Filma findFilmaById(String id);

    List<Filma> findFilmaByCountry(String country);

    /**
     * Saves a Filma entity to the database.
     * 
     * @param filma the Filma entity to save
     * @return the saved Filma entity
     */
    Filma save(Filma filma);

    /**
     * Deletes a Filma entity from the database based on its ID.
     * 
     * @param id the ID of the Filma entity to delete
     * @return the number of entities deleted
     */
    long deleteById(String id);

    long deleteByTitle(String title);

}