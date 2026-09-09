package com.ludson.museumfinder.controller;

import com.ludson.museumfinder.dto.MuseumCreationDto;
import com.ludson.museumfinder.dto.MuseumDto;
import com.ludson.museumfinder.model.Coordinate;
import com.ludson.museumfinder.model.Museum;
import com.ludson.museumfinder.service.MuseumServiceInterface;
import com.ludson.museumfinder.util.ModelDtoConverter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe para mapeamento para a rota "/museums".
 */
@Tag(name = "Museums", description = "Endpoints para gerenciamento e busca geoespacial de museus")
@RestController
@RequestMapping("/museums")
public class MuseumController {
  MuseumServiceInterface museumServiceInterface;

  /**
   * Construtor da minha classe.
   *
   * @param museumServiceInterface Seria o meu service.
   */
  public MuseumController(MuseumServiceInterface museumServiceInterface) {
    this.museumServiceInterface = museumServiceInterface;
  }

  /**
   * Método que mapeia a rota post para cadastro de novos museus.
   *
   * @param museumCreationDto O tipo de arquivo que é recebido.
   * @return retornar o museum criado sem os dados sensíveis.
   */
  @Operation(summary = "Cadastrar novo museu", description = "Cadastra um novo museu no sistema")
  @PostMapping
  public ResponseEntity<MuseumDto> createMuseum(@RequestBody MuseumCreationDto museumCreationDto) {

    Museum newMuseum = ModelDtoConverter.dtoToModel(museumCreationDto);

    Museum addedMuseum = museumServiceInterface.createMuseum(newMuseum);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(ModelDtoConverter.modelToDto(addedMuseum));
  }

  /**
   * Método que mapeia a rota GET com query string.
   *
   * @param lat recebe um lat
   * @param lng recebe
   * @param maxDistance recebe
   * @return retorna um museum sem os dados sensíveis.
   */
  @Operation(
      summary = "Buscar museu mais próximo",
      description = "Retorna o museu mais próximo de uma dada coordenada geográfica dentro do raio máximo especificado"
  )
  @GetMapping("/closest")
  public ResponseEntity<MuseumDto> getClosestMuseum(
      @RequestParam Double lat,
      @RequestParam Double lng,
      @RequestParam("max_dist_km") Double maxDistance
  ) {

    Coordinate coordinate = new Coordinate(lat, lng);

    Museum museum = museumServiceInterface.getClosestMuseum(coordinate, maxDistance);

    MuseumDto museumDto = ModelDtoConverter.modelToDto(museum);

    return ResponseEntity.ok().body(museumDto);
  }

  /**
   * Método que retorna museu de acordo com o id.
   *
   * @param id id do museu desejado.
   * @return retorna um museu sem os dados sensíveis.
   */
  @Operation(summary = "Buscar museu por ID", description = "Retorna os detalhes de um museu específico a partir do seu ID")
  @GetMapping("{id}")
  public ResponseEntity<MuseumDto> getMuseum(@PathVariable Long id) {
    Museum museum = museumServiceInterface.getMuseum(id);

    MuseumDto museumDto = ModelDtoConverter.modelToDto(museum);

    return ResponseEntity.ok().body(museumDto);
  }
}