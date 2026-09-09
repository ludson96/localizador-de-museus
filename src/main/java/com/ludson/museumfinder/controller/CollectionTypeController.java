package com.ludson.museumfinder.controller;

import com.ludson.museumfinder.dto.CollectionTypeCount;
import com.ludson.museumfinder.service.CollectionTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CollectionType controller class.
 */
@Tag(name = "Collections", description = "Endpoints para consulta e contagem de tipos de acervo")
@RestController
@RequestMapping("/collections")
public class CollectionTypeController {

  private final CollectionTypeService service;

  @Autowired
  CollectionTypeController(CollectionTypeService service) {
    this.service = service;
  }

  /**
   * Route to count number of Museums with certain collection types.
   */
  @Operation(
      summary = "Contagem de museus por tipos de acervo",
      description = "Retorna o total de museus associados a uma lista de tipos de acervo separados por vírgula (ex: historia,artes)"
  )
  @GetMapping("/count/{typesList}")
  public ResponseEntity<CollectionTypeCount>
      getCollectionTypesCount(@PathVariable String typesList) {
    CollectionTypeCount result = service.countByCollectionTypes(typesList);

    if (result.count() > 0) {
      return ResponseEntity.ok(result);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
