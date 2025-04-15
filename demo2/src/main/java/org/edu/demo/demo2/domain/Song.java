package org.edu.demo.demo2.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

@Data
@Entity
public class Song {
    //Primar Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //Columns
    @Column(name = "song_title", nullable = false)
    private String title;

    @Column(name = "song_release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "song_duration", nullable = false, columnDefinition = "INTEGER CHECK (song_duration>= 0)")
    private Integer duration;

    //Relacion
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "song_genre",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres = new ArrayList<>();
}
