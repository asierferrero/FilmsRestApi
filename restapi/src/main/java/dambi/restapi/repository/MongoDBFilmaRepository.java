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

@Repository
public class MongoDBFilmaRepository implements FilmaRepository {
    // private static final TransactionOptions txnOptions = TransactionOptions.builder()
    //                                                                        .readPreference(ReadPreference.primary())
    //                                                                        .readConcern(ReadConcern.MAJORITY)
    //                                                                        .writeConcern(WriteConcern.MAJORITY)
    //                                                                        .build();
    @Autowired
    private MongoClient client;
    private MongoCollection<Filma> filmaCollection;

    @PostConstruct
    void init() {
        filmaCollection = client.getDatabase("prueba").getCollection("prueba", Filma.class);
    }

    @Override
    public List<Filma> findAll() {
        return filmaCollection.find().into(new ArrayList<>());
    }

    @Override
    public Filma findFilmaById(String id) {
        return filmaCollection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public List<Filma> findFilmaByCountry(String country) {
        return filmaCollection.find(eq("country", country)).into(new ArrayList<>());
    }

    @Override
    public Filma save(Filma filma) {
        filmaCollection.insertOne(filma);
        return filma;
    }

    @Override
    public long deleteById(String _id) {
        return filmaCollection.deleteMany(eq("_id", new ObjectId(_id))).getDeletedCount();
    }

    @Override
    public long deleteByTitle(String title) {
        return filmaCollection.deleteMany(eq("title", title)).getDeletedCount();
    }
}
