package es.iesrafaelalberti.daw.dwes.jparestdemo2.boot;

import es.iesrafaelalberti.daw.dwes.jparestdemo2.model.Pesado;
import es.iesrafaelalberti.daw.dwes.jparestdemo2.repositories.PesadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    private PesadoRepository pesadoRepository;

    @Override
    public void run(String... args) throws Exception {
        pesadoRepository.save(new Pesado("Javier", 50));
        pesadoRepository.save(new Pesado("Andrés", 25));
        pesadoRepository.save(new Pesado("Cabesa", 14));
        pesadoRepository.save(new Pesado("Lucía", 75));
        pesadoRepository.save(new Pesado("Paula", 20));
        pesadoRepository.save(new Pesado("Teresa", 18));
        pesadoRepository.save(new Pesado("Edu", 98));
    }
}
