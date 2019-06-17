package com.hotels.imageretrievalservice.service;

import com.hotels.imageretrievalservice.configuration.GoogleProperties;
import com.hotels.imageretrievalservice.model.GoogleResults;
import com.hotels.imageretrievalservice.model.Item;
import com.hotels.imageretrievalservice.repository.GoogleSearchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GoogleSearchService {

    private final GoogleSearchRepository googleSearchRepository;
    private final GoogleProperties googleProperties;

    public List<Item> search(String destination) {

        String googleSearchUrl = createUrl(destination);

        GoogleResults results = googleSearchRepository.getResults(googleSearchUrl);

        return results.getItems().stream()
                .filter(Objects::nonNull)
                .map(item -> new Item(Math.abs(item.getLink().hashCode()), item.getLink()))
                .limit(10)
                .collect(Collectors.toList());
    }

    public Item searchRandom(String destination) {

        String googleSearchUrl = createUrl(destination);

        GoogleResults results = googleSearchRepository.getResults(googleSearchUrl);

        Random rand = new Random();
        return results.getItems().get(rand.nextInt(results.getItems().size()));
    }

    private String createUrl(String destination) {
        return  googleProperties.getGoogleApiBaseUrl()
                + "?key=" + googleProperties.getApiKey()
                + "&cx=" + googleProperties.getCustomSearchEngineId()
                + "&q=" + destination
                + "&num=" + googleProperties.getNumberOfSearchResults()
                + "&imgSize=" + googleProperties.getImageSize()
                + "&searchType=" + googleProperties.getSearchType()
                + "&imgType=" + googleProperties.getImgType();
    }
}
