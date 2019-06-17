package com.hotels.imageretrievalservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Queries {

    private List<NextPage> nextPage;
    private List<Request> request;
}
