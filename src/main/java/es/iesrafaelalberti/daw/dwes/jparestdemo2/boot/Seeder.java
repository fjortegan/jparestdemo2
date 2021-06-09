package es.iesrafaelalberti.daw.dwes.jparestdemo2.boot;

import es.iesrafaelalberti.daw.dwes.jparestdemo2.model.Calvo;
import es.iesrafaelalberti.daw.dwes.jparestdemo2.model.Pesado;
import es.iesrafaelalberti.daw.dwes.jparestdemo2.repositories.CalvoRepository;
import es.iesrafaelalberti.daw.dwes.jparestdemo2.repositories.PesadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    private PesadoRepository pesadoRepository;
    @Autowired
    private CalvoRepository calvoRepository;

    @Override
    public void run(String... args) throws Exception {
        Calvo c2 = calvoRepository.save(new Calvo("Javier", 20));
        Calvo c1 = calvoRepository.save(new Calvo("Alejandro", 0));

        pesadoRepository.save(new Pesado("Andrés", 25, c1));
        pesadoRepository.save(new Pesado("Cabesa", 14, c1));
        pesadoRepository.save(new Pesado("Lucía", 75, c1));
        pesadoRepository.save(new Pesado("Paula", 20, c2));
        pesadoRepository.save(new Pesado("Teresa", 18, c2));
        pesadoRepository.save(new Pesado("Edu", 98, c2));
    }
}
