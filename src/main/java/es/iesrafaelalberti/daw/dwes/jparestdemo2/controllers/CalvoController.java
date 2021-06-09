package es.iesrafaelalberti.daw.dwes.jparestdemo2.controllers;

import es.iesrafaelalberti.daw.dwes.jparestdemo2.model.Calvo;
import es.iesrafaelalberti.daw.dwes.jparestdemo2.repositories.CalvoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CalvoController {
    @Autowired
    CalvoRepository calvoRepository;

    @GetMapping("/calvos")
    public ResponseEntity<Object> calvoList() {
        return new ResponseEntity<>(calvoRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/calvos/detail")
    public ResponseEntity<Object> calvoDetail(@RequestParam("id") Long id) {
        Calvo calvo = calvoRepository.findById(id)
                                        .orElseThrow(() -> new EntityNotFoundException());
        return new ResponseEntity<>(calvo, HttpStatus.OK);
    }

    @PostMapping("/calvos")
    public ResponseEntity<?> calvoAdd(@RequestParam("name") String name,
                                       @RequestParam("area") int area) {
        Calvo nuevoCalvo = new Calvo(name, area);
        calvoRepository.save(nuevoCalvo);
        return new ResponseEntity<>(nuevoCalvo, HttpStatus.OK);
    }

    @PostMapping("/calvos/add")
    public ResponseEntity<?> calvoAdd(@RequestBody Calvo nuevoCalvo) {
        calvoRepository.save(nuevoCalvo);
        return new ResponseEntity<>(nuevoCalvo, HttpStatus.OK);
    }


    @PutMapping("/calvos/{id}")
    public ResponseEntity<?> calvoUpdate(@PathVariable("id") Long id,
                                          @RequestBody Calvo nuevoCalvo) {
        calvoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        //nuevocalvo.setId(id);
        calvoRepository.save(nuevoCalvo);
        return new ResponseEntity<>(nuevoCalvo, HttpStatus.OK);
    }


    @DeleteMapping("/calvos/{id}")
    public ResponseEntity<?> calvoDelete(@PathVariable("id") Long id) {
        Calvo oldCalvo = calvoRepository.findById(id)
                                           .orElseThrow(() -> new EntityNotFoundException());
        calvoRepository.delete(oldCalvo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
