package dambi.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dambi.restapi.model.Cast;
import dambi.restapi.model.Filma;
import dambi.restapi.repository.FilmaRepository;

/**
 * The FilmaController class is responsible for handling requests to the Filma REST API.
 * It provides methods for retrieving, adding, updating, and deleting Filma objects.
 */
@RestController
@RequestMapping("/filmak")
public class FilmaController {

    /**
     * The FilmaRepository object is used to interact with the database.
     */
    @Autowired
    private FilmaRepository filmaRepository;

    /**
     * Returns a list of all Filma objects in the database.
     *
     * @return a list of Filma objects
     */
    @GetMapping(value = "/guztiak")
    public List<Filma> getFilmak() {
        return filmaRepository.findAll();
    }

    /**
     * Returns a Filma object with the specified ID.
     *
     * @param _id the ID of the Filma object to retrieve
     * @return the Filma object with the specified ID, or null if no object with that ID exists
     */
    @GetMapping(value = "/bilatu")
    public Filma getMovieById(@RequestParam String _id) {
        return filmaRepository.findFilmaById(_id);
    }

    /**
     * Returns a list of Filma objects with the specified country.
     *
     * @param country the country of the Filma objects to retrieve
     * @return a list of Filma objects with the specified country
     */
    @GetMapping(value = "/bilatuHerrialdeka")
    public List<Filma> getMovieByCountry(@RequestParam String country) {
        return filmaRepository.findFilmaByCountry(country);
    }

    /**
     * Adds a new Filma object to the database.
     *
     * @param title    the title of the Filma object
     * @param year     the year the Filma object was released
     * @param kind     the type of Filma (e.g. "Komedia", "Drama")
     * @param genre    the genre of the Filma (e.g. "Aktoreak", "Aventura")
     * @param rating   the IMDb rating of the Filma
     * @param vote     the number of votes the Filma received on IMDb
     * @param country  the country where the Filma was produced
     * @param language the language of the Filma
     * @param cast     a list of Cast objects that appear in the Filma
     * @param writer   the name of the writer of the Filma
     * @return a message indicating whether the Filma was added successfully
     */
    @PostMapping(value = "/gehitu")
    public String addMovie(@RequestParam String title, @RequestParam int year, @RequestParam String kind,
            @RequestParam(required = false) String genre, double rating,
            @RequestParam int vote,
            @RequestParam(required = false) String country,
            @RequestParam String language, @RequestBody(required = false) List<Cast> cast,
            @RequestParam(required = false) String writer) {
        try {
            Filma filma = new Filma();
            filma.setTitle(title);
            filma.setYear(year);
            filma.setKind(kind);
            filma.setGenre(genre);
            filma.setRating(rating);
            filma.setVote(vote);
            filma.setCountry(country);
            filma.setLanguage(language);
            filma.setCast(cast);
            filma.setWriter(writer);
            filmaRepository.save(filma);
            return title + " izeneko filma gehitu egin da. ";
        } catch (Exception e) {
            return title + " izeneko filma ezin izan da gehitu. ";
        }
    }

    /**
     * Updates an existing Filma object in the database.
     *
     * @param _id      the ID of the Filma object to update
     * @param title    the title of the Filma object
     * @param year     the year the Filma object was released
     * @param kind     the type of Filma (e.g. "Komedia", "Drama")
     * @param genre    the genre of the Filma (e.g. "Aktoreak", "Aventura")
     * @param rating   the IMDb rating of the Filma
     * @param vote     the number of votes the Filma received on IMDb
     * @param country  the country where the Filma was produced
     * @param language the language of the Filma
     * @param cast     a list of Cast objects that appear in the Filma
     * @param writer   the name of the writer of the Filma
     * @return a message indicating whether the Filma was updated successfully
     */
    @PutMapping(value = "/eguneratu/{_id}")
    public String updateMovie(@PathVariable String _id, @RequestParam String title, @RequestParam int year,
            @RequestParam String kind,
            @RequestParam(required = false) String genre, double rating,
            @RequestParam int vote,
            @RequestParam(required = false) String country,
            @RequestParam String language, @RequestBody(required = false) List<Cast> cast,
            @RequestParam(required = false) String writer) {

        try {
            Filma filma = filmaRepository.findFilmaById(_id);
            filma.setTitle(title);
            filma.setYear(year);
            filma.setKind(kind);
            filma.setGenre(genre);
            filma.setRating(rating);
            filma.setVote(vote);
            filma.setCountry(country);
            filma.setLanguage(language);
            filma.setCast(cast);
            filma.setWriter(writer);
            filmaRepository.save(filma);
            return _id + " id-a duen filma eguneratu egin da. ";
        } catch (Exception e) {
            e.printStackTrace();
            return _id + " id-a duen filma ezin izan da eguneratu. ";
        }
    }

    /**
     * Deletes an existing Filma object from the database.
     *
     * @param _id the ID of the Filma object to delete
     * @return a message indicating whether the Filma was deleted successfully
     */
    @DeleteMapping(value = "/ezabatu/{_id}")
    public String deleteMovie(@PathVariable String _id) {
        try {
            filmaRepository.deleteById(_id);
            return _id + " id-a duen filma zuzen ezabatu da. ";
        } catch (Exception e) {
            return _id + " id-a duen filma ez da existizen. ";
        }
    }

    /**
     * Deletes an existing Filma object from the database based on the title.
     *
     * @param title the title of the Filma object to delete
     * @return a message indicating whether the Filma was deleted successfully
     */
    @DeleteMapping(value = "/ezabatu")
    public String deleteMovieByTitle(@RequestParam String title) {
        try {
            filmaRepository.deleteByTitle(title);
            return title + " filma zuzen ezabatu da. ";
        } catch (Exception e) {
            return title + " filma ez da existizen. ";
        }
    }
}