package com.hotels.imageretrievalservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoogleResults {

        private Context context;
        private List<Item> items;
        private String kind;
        private Queries queries;
        private SearchInformation searchInformation;
        private Url url;

}
