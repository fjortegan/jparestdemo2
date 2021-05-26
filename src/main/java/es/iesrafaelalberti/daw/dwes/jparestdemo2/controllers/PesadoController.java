package es.iesrafaelalberti.daw.dwes.jparestdemo2.controllers;

import es.iesrafaelalberti.daw.dwes.jparestdemo2.model.Pesado;
import es.iesrafaelalberti.daw.dwes.jparestdemo2.repositories.PesadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
public class PesadoController {
    @Autowired
    PesadoRepository pesadoRepository;

    @GetMapping("/pesados")
    public ResponseEntity<Object> pesadoList() {
        return new ResponseEntity<>(pesadoRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/pesados/detail")
    public ResponseEntity<Object> pesadoDetail(@RequestParam("id") Long id) {
        Pesado pesado = pesadoRepository.findById(id)
                                        .orElseThrow(() -> new EntityNotFoundException());
        return new ResponseEntity<>(pesado, HttpStatus.OK);
    }

    @PostMapping("/pesados")
    public ResponseEntity<?> pesadoAdd(@RequestParam("name") String name,
                                       @RequestParam("age") int age) {
        Pesado nuevoPesado = new Pesado(name, age);
        pesadoRepository.save(nuevoPesado);
        return new ResponseEntity<>(nuevoPesado, HttpStatus.OK);
    }

    @PostMapping("/pesados/add")
    public ResponseEntity<?> pesadoAdd(@RequestBody Pesado nuevoPesado) {
        pesadoRepository.save(nuevoPesado);
        return new ResponseEntity<>(nuevoPesado, HttpStatus.OK);
    }


    @PutMapping("/pesados/{id}")
    public ResponseEntity<?> pesadoUpdate(@PathVariable("id") Long id,
                                          @RequestBody Pesado nuevoPesado) {
        pesadoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        //nuevoPesado.setId(id);
        pesadoRepository.save(nuevoPesado);
        return new ResponseEntity<>(nuevoPesado, HttpStatus.OK);
    }


    @DeleteMapping("/pesados/{id}")
    public ResponseEntity<?> pesadoDelete(@PathVariable("id") Long id) {
        Pesado oldPesado = pesadoRepository.findById(id)
                                           .orElseThrow(() -> new EntityNotFoundException());
        pesadoRepository.delete(oldPesado);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
