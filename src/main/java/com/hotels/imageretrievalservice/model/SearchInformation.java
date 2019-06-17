package com.hotels.imageretrievalservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class SearchInformation {

    private String formattedSearchTime;
    private String formattedTotalResults;
    private Number searchTime;
    private String totalResults;
}
