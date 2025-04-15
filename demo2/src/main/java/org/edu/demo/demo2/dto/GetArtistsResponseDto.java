package org.edu.demo.demo2.dto;

import lombok.Data;
import org.edu.demo.demo2.domain.Artist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class GetArtistsResponseDto {
    private String name;
    private String bio;
    private LocalDate birthDate;
    private List<Long> songIdList = new ArrayList<>();
}
