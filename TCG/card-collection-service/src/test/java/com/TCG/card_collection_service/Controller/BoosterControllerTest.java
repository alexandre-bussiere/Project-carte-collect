package com.TCG.card_collection_service.Controller;

import com.TCG.card_collection_service.controller.BoosterController;
import com.TCG.card_collection_service.model.Booster;
import com.TCG.card_collection_service.service.BoosterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@WebMvcTest(BoosterController.class)
public class BoosterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoosterService boosterService;

    @Autowired
    private ObjectMapper objectMapper;

    // @Test
    // public void createBooster() throws Exception {
    // // Créer un objet Booster pour le test
    // Booster booster = new Booster("Magic Booster", "Rare", 10, "20%");

    // // Simuler la méthode de création dans BoosterService
    // when(boosterService.createBooster(booster)).thenReturn(booster);

    // // Effectuer une requête POST et vérifier les résultats
    // mockMvc.perform(post("TCG/boosters")
    // .contentType(MediaType.APPLICATION_JSON)
    // .content(objectMapper.writeValueAsString(booster)))
    // .andExpect(status().isOk())
    // .andExpect(jsonPath("$.name", is("Magic Booster")))
    // .andExpect(jsonPath("$.rarity", is("Rare")))
    // .andExpect(jsonPath("$.cost", is(10)))
    // .andExpect(jsonPath("$.dropRate", is("20%")));
    // }
}
