package com.hotels.imageretrievalservice.repository;

import com.hotels.imageretrievalservice.model.GoogleResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class GoogleSearchRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Cacheable("results")
    public GoogleResults getResults(String googleSearchUrl) {
        return restTemplate.getForObject(googleSearchUrl, GoogleResults.class);
    }
}
