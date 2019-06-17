package com.hotels.imageretrievalservice.controller;

import com.hotels.imageretrievalservice.model.Item;
import com.hotels.imageretrievalservice.service.GoogleSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ImageRetrievalController {

    private final GoogleSearchService googleSearchService;

    @GetMapping("/search/{destination}")
    public List<Item> getImages(@PathVariable("destination") String destination) {
        return googleSearchService.search(destination);
    }

    @GetMapping("/search/random/{destination}")
    public Item getRandomImage(@PathVariable("destination") String destination) {
        return googleSearchService.searchRandom(destination);
    }
}
