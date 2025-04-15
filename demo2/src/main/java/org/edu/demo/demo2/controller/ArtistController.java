package org.edu.demo.demo2.controller;

import jakarta.validation.Valid;
import org.edu.demo.demo2.domain.Artist;
import org.edu.demo.demo2.domain.Song;
import org.edu.demo.demo2.dto.GetArtistsResponseDto;
import org.edu.demo.demo2.dto.NewArtirstRequestDto;
import org.edu.demo.demo2.exceptions.ResourceNotFoundException;
import org.edu.demo.demo2.repository.ArtistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;
//    public ArtistController(ArtistRepository artistRepository) {
//        this.artistRepository = artistRepository;
//    } otra forma sin Autowired
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<String> createArtist(@Valid @RequestBody NewArtirstRequestDto NewArtirstRequestDto) {
          Artist artist = modelMapper.map(NewArtirstRequestDto, Artist.class);
//        Artist artist = new Artist();
//        artist.setName(NewArtirstRequestDto.getName());
//        artist.setBio(NewArtirstRequestDto.getBio());
//        artist.setBirhtDate(NewArtirstRequestDto.getBirthDate());

        Artist savedArtist = artistRepository.save(artist);
        URI location = URI.create("/artists/" + savedArtist.getId());
        return ResponseEntity.created(location).body("Artist created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetArtistsResponseDto> getArtistById(@PathVariable Long id) {
// 1RA Y 2DA       Optional<Artist> artist = artistRepository.findById(id);
        Artist artist = artistRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artist whith Id "+ id + " not found"));
// 1RA Y 2DA       if(artist.isPresent()) {
        GetArtistsResponseDto responseDto = modelMapper.map(artist, GetArtistsResponseDto.class);
// 2DA           GetArtistsResponseDto responseDto = modelMapper.map(artist.get(), GetArtistsResponseDto.class);
// 1RA           GetArtistsResponseDto responseDto = new GetArtistsResponseDto();
// 1RA           responseDto.setName(artist.get().getName());
// 1RA           responseDto.setBio(artist.get().getBio());
// 1RA           responseDto.setBirthDate(artist.get().getBirhtDate());
            List<Long> ids = new ArrayList<>();
            for(Song song : artist.getSongs()) {
                ids.add(song.getId());
            }
            responseDto.setSongIdList(ids);
            return ResponseEntity.ok(responseDto);
        }
// 1RA Y 2DA else{
// 1RA Y 2DA            return ResponseEntity.notFound().build();
// 1RA Y 2DA        }
}
