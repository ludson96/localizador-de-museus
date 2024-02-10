package com.betrybe.museumfinder.solution;

import static org.mockito.ArgumentMatchers.any;

import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Teste CollectionTypeController")
public class CollectionTypeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CollectionTypeService collectionTypeService;

  @Test
  @DisplayName("Testa se retornar número de museus com determinados tipos de coleção")
  public void testGetCollectionTypesCount() throws Exception {

    String[] inputMock = {"AA", "BB"};

    CollectionTypeCount collectionMock = new CollectionTypeCount(inputMock, 5);

    Mockito
        .when(collectionTypeService.countByCollectionTypes(any()))
        .thenReturn(collectionMock);

    ResultActions result = mockMvc.perform(
        get("/collections/count/{typesList}", String.join(",", inputMock))
    );

    result.andExpect(status().isOk());

    Mockito.verify(collectionTypeService).countByCollectionTypes(any());
  }

  @Test
  @DisplayName("Testa se retornar mensagem de erro NotFound")
  public void testGetCollectionTypesNotFound() throws Exception {

    String[] inputMock = {};

    String[] inputPath = {"AA"};

    CollectionTypeCount collectionMock = new CollectionTypeCount(inputMock, 0);

    Mockito
        .when(collectionTypeService.countByCollectionTypes(any()))
        .thenReturn(collectionMock);

    ResultActions result = mockMvc.perform(
        get("/collections/count/{typesList}", String.join(",", inputPath))
    );

    result.andExpect(status().isNotFound());

    Mockito.verify(collectionTypeService).countByCollectionTypes(any());
  }
}
