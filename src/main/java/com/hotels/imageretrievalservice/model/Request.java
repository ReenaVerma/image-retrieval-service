package com.hotels.imageretrievalservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Request {

    private Number count;
    private String cx;
    private String inputEncoding;
    private String outputEncoding;
    private String safe;
    private String searchTerms;
    private Number startIndex;
    private String title;
    private String totalResults;
}
