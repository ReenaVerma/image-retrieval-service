# image-retrieval-service

This service is awesome and is used to retrieve images from Google Search API.

Cache is enabled in order to avoid Google daily requests limit and boost performance.

## How to use

Get list of links given a location:
`http://localhost:8080/search/{destination}`

Get random link given a location:
`http://localhost:8080/search/random/{destination}`