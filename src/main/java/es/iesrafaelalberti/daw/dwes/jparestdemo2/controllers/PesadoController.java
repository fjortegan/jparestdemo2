package es.iesrafaelalberti.daw.dwes.jparestdemo2.controllers;

import es.iesrafaelalberti.daw.dwes.jparestdemo2.model.Pesado;
import es.iesrafaelalberti.daw.dwes.jparestdemo2.repositories.PesadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PesadoController {
    @Autowired
    PesadoRepository pesadoRepository;

    @GetMapping("/pesados")
    public ResponseEntity<Object> pesadoList() {
        return new ResponseEntity<>(pesadoRepository.findAll(), HttpStatus.OK);
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
}
