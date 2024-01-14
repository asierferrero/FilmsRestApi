package dambi.restapi.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import dambi.restapi.model.Filma;
import jakarta.annotation.PostConstruct;

import static com.mongodb.client.model.Filters.eq;

/**
 * This class provides an implementation of the FilmaRepository interface, which is used to interact with the database of film information.
 * The repository uses the Spring framework to inject the MongoClient instance, which is used to interact with the MongoDB database.
 * The repository uses the MongoDB Java Driver to interact with the database collections.
 */
@Repository
public class MongoDBFilmaRepository implements FilmaRepository {
    @Autowired
    private MongoClient client;
    private MongoCollection<Filma> filmaCollection;

    @PostConstruct
    void init() {
        filmaCollection = client.getDatabase("filma").getCollection("filmak", Filma.class);
    }

    /**
     * This method is used to retrieve all the film information from the database.
     * @return a list of Filma objects, or an empty list if no films are found
     */
    @Override
    public List<Filma> findAll() {
        return filmaCollection.find().into(new ArrayList<>());
    }

    /**
     * This method is used to retrieve a Filma object from the database based on its ID.
     * @param id the ID of the film to retrieve
     * @return a Filma object, or null if no film with the specified ID is found
     */
    @Override
    public Filma findFilmaById(String id) {
        return filmaCollection.find(eq("_id", new ObjectId(id))).first();
    }

    /**
     * This method is used to retrieve a list of Filma objects from the database based on the country they were produced in.
     * @param country the country to filter by
     * @return a list of Filma objects, or an empty list if no films are found
     */
    @Override
    public List<Filma> findFilmaByCountry(String country) {
        return filmaCollection.find(eq("country", country)).into(new ArrayList<>());
    }

    /**
     * This method is used to save a Filma object to the database.
     * @param filma the Filma object to save
     * @return the saved Filma object
     */
    @Override
    public Filma save(Filma filma) {
        filmaCollection.insertOne(filma);
        return filma;
    }

    /**
     * This method is used to delete a Filma object from the database based on its ID.
     * @param id the ID of the film to delete
     * @return the number of documents deleted
     */
    @Override
    public long deleteById(String id) {
        return filmaCollection.deleteMany(eq("_id", new ObjectId(id))).getDeletedCount();
    }

    /**
     * This method is used to delete a Filma object from the database based on its title.
     * @param title the title of the film to delete
     * @return the number of documents deleted
     */
    @Override
    public long deleteByTitle(String title) {
        return filmaCollection.deleteMany(eq("title", title)).getDeletedCount();
    }
}
