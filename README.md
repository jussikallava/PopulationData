# Personal Registry Creation Tool

Spring boot, RESTful web service for creating people, municipalities and provinces.
The application has been developed to test Neo4j's Object Graph Mapping (OGM) library.

Use this application to create random material based on name and city information.

Name and municipality information has been requested from the "avoindata"-service and are provided by the Population Register Center
https://www.avoindata.fi/

# Install

- Install Neo4j (https://neo4j.com/) (Brew: brew install neo4j)
- Run it (neo4j run)
- Configure neo4j port to db.properties
- build maven project (mvn clean install)
- deploy war

# API endpoints
- /population/v1/create/counties
- /population/v1/create/lastnames
- /population/v1/create/men/firstname
- /population/v1/create/women/firstname
- /population/v1/create/municipalities

## Neo4j password change
:server change-password