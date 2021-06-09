package es.iesrafaelalberti.daw.dwes.jparestdemo2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter
@Entity
public class Pesado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn()
    private Calvo calvito;

    private String name;
    private int age;

    public Pesado() {
    }

    public Pesado(String name, int age, Calvo calvo) {
        this.name = name;
        this.age = age;
        this.calvito = calvo;
    }
}
