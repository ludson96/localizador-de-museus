package com.betrybe.museumfinder.solution;

import static org.mockito.ArgumentMatchers.any;

import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.solution.Utils.TestHelpers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testando camada Controller/Apresentação")
public class MuseumControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private MuseumServiceInterface service;

  @Test
  @DisplayName("Testando rota POST '/museums'")
  public void testCreateMuseum() throws Exception {
    Museum museum = TestHelpers.createMockMuseum(1L);

    String inputMuseum = "{ \"name\": \"Museum Name\","
        + " \"description\": \"Museum Location\","
        + " \"address\": \"casa\","
        + " \"collectionType\": \"his\","
        + " \"subject\": \"nao\","
        + " \"url\": \"teste\""
        + " }";


    Mockito
        .when(service.createMuseum(any()))
        .thenReturn(museum);

    mockMvc.perform(post("/museums")
        .contentType(MediaType.APPLICATION_JSON)
            .content(inputMuseum))
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").value(1L));
  }

  @Test
  @DisplayName("Testando rota GET '/closest'")
  public void testGetClosestMuseum() throws Exception {

    Museum museum = TestHelpers.createMockMuseum(3L);

    Mockito
        .when(service.getClosestMuseum(any(), any()))
        .thenReturn(museum);

    mockMvc.perform(get("/museums/closest?lat=-20.4435&lng=-54.6478&max_dist_km=10")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").value(3L));
  }

  @Test
  @DisplayName("Testando rota GET '/{id}'")
  public void testGetMuseumById() throws Exception {

    Museum museum = TestHelpers.createMockMuseum(6L);

    Mockito
        .when(service.getMuseum(any()))
        .thenReturn(museum);

    mockMvc.perform(get("/museums/6")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").value(6L));
  }
}
