package com.hotels.imageretrievalservice.controller;

import com.hotels.imageretrievalservice.model.Item;
import com.hotels.imageretrievalservice.service.GoogleSearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
public class ImageRetrievalControllerTest {

    @MockBean
    private GoogleSearchService googleSearchService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getImagesThenReturnsListOfLinks() throws Exception {

        when(googleSearchService.search(anyString())).thenReturn(Arrays.asList(
                new Item(1, "image_1"),
                new Item(2, "image_2"))
        );

        this.mockMvc.perform(get("/search/london")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id").value(1))
                .andExpect(jsonPath("$.[0].link").value("image_1"))
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void getRandomImageThenReturnOneLink() throws Exception {

        when(googleSearchService.searchRandom(anyString())).thenReturn(new Item(1, "image_1"));

        this.mockMvc.perform(get("/search/random/london"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.link").value("image_1"));
    }

}