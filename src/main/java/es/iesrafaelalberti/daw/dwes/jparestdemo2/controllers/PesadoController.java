package es.iesrafaelalberti.daw.dwes.jparestdemo2.controllers;

import es.iesrafaelalberti.daw.dwes.jparestdemo2.repositories.PesadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PesadoController {
    @Autowired
    PesadoRepository pesadoRepository;

    @GetMapping("/pesados")
    public ResponseEntity<Object> pesadoList() {
        return new ResponseEntity<>(pesadoRepository.findAll(), HttpStatus.OK);
    }
}
