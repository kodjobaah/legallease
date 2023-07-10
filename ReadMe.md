# FirmRankings
## Framework
I chose to use spring, due to its maturity and the extensive amount of suport it has.

## Securing Endpoint

Due to time constraints, I was not able to implement the feature to secure the endpoint.
The approach I would have taken would have been as follows:
- JWT Token.
  Provide a means for a user to acquire JWT token that would be used in the header.
  This can be achieved by creating an endpoint or using a third party that provides Auth0 services.
- When user makes a request, in the bearer token of the header they will need to add the JWT token.
- On the server side we would then retrieve this token from the header and validate it to determine
  if the user has the right permissions to be able to access the endpoint.

## Containerize app
In order to containerize the app, you will need to make sure you have docker instqalled.
```sh
 mvn clean package (This should also run all the tests)
 docker build --tag=firmranking:latest .
 docker run -p8001:8080 firmranking:latest
```