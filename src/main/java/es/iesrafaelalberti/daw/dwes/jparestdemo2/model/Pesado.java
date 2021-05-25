package es.iesrafaelalberti.daw.dwes.jparestdemo2.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter @Getter
@Entity
public class Pesado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;

    public Pesado() {
    }

    public Pesado(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
