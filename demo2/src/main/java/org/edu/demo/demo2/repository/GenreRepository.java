package org.edu.demo.demo2.repository;
import org.edu.demo.demo2.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository  extends JpaRepository<Genre, Long> {
}
