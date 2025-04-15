package org.edu.demo.demo2.repository;
import org.edu.demo.demo2.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
