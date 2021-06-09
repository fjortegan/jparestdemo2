package es.iesrafaelalberti.daw.dwes.jparestdemo2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
public class Calvo {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@JsonBackReference
    @OneToMany(mappedBy = "calvito", cascade = CascadeType.ALL)
    Set<Pesado> pesados = new HashSet<>();

    private String name;
    private int landingArea;

    public Calvo() {
    }

    public Calvo(String name, int landingArea) {
        this.name = name;
        this.landingArea = landingArea;
    }
}
