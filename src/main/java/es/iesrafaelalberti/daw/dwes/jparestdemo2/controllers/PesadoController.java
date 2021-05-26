package es.iesrafaelalberti.daw.dwes.jparestdemo2.controllers;

import es.iesrafaelalberti.daw.dwes.jparestdemo2.model.Pesado;
import es.iesrafaelalberti.daw.dwes.jparestdemo2.repositories.PesadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Optional<Pesado> pesado = pesadoRepository.findById(id);
        if(pesado.isPresent()) {
            return new ResponseEntity<>(pesado.get(), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
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
    @DeleteMapping("/pesados/{id}")
    public ResponseEntity<?> pesadoDelete(@PathVariable("id") Long id) {
        Optional<Pesado> oldPesado = pesadoRepository.findById(id);
        if(oldPesado.isPresent()) {
            pesadoRepository.delete(oldPesado.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        //return ResponseEntity.notFound().build();
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
