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

@RestController
@RequestMapping("/filmak")
public class FilmaController {
    @Autowired
    private FilmaRepository filmaRepository;

    @GetMapping(value = "/guztiak")
    public List<Filma> getFilmak() {
        return filmaRepository.findAll();
    }

    @GetMapping(value = "/bilatu")
    public Filma getMovieById(@RequestParam String _id) {
        return filmaRepository.findFilmaById(_id);
    }

    @GetMapping(value = "/bilatuHerrialdeka")
    public List<Filma> getMovieByCountry(@RequestParam String country) {
        return filmaRepository.findFilmaByCountry(country);
    }

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

    @DeleteMapping(value = "/ezabatu/{_id}")
    public String deleteMovie(@PathVariable String _id) {
        try {
            filmaRepository.deleteById(_id);
            return _id + " id-a duen filma zuzen ezabatu da. ";
        } catch (Exception e) {
            return _id + " id-a duen filma ez da existizen. ";
        }
    }

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