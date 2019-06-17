package com.hotels.imageretrievalservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "google.properties")
public class GoogleProperties {

    private String googleApiBaseUrl;
    private String apiKey;
    private String customSearchEngineId;
    private String numberOfSearchResults;
    private String imageSize;
    private String searchType;
    private String imgType;
}
