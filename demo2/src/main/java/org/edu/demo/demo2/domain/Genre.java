package org.edu.demo.demo2.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Genre {
    //Primar Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //Columns
    @Column(name = "genre_name", nullable = false, unique = true)
    private String name;

    @Column(name = "genre_description", length = 1000)
    private String description;
    //Relacion
    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
    private List<Song> songs;
}
