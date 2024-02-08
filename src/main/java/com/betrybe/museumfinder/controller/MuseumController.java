package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/museums")
public class MuseumController {
  MuseumServiceInterface museumServiceInterface;

  public MuseumController(MuseumServiceInterface museumServiceInterface) {
    this.museumServiceInterface = museumServiceInterface;
  }

  @PostMapping
  public ResponseEntity<MuseumDto> createMuseum(MuseumCreationDto museumCreationDto) {

    Museum newMuseum = ModelDtoConverter.dtoToModel(museumCreationDto);

    Museum addedMuseum = museumServiceInterface.createMuseum(newMuseum);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(ModelDtoConverter.modelToDto(addedMuseum));
  }
}