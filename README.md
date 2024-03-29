# GraphQL-Kotlin-Mongo
### Introduction
This project is a small demo that introduces how to write a GraphQL service using Kotlin,
Spring Boot, and MongoDB. 

Based off of [this project](https://blog.pusher.com/writing-graphql-service-using-kotlin-spring-boot/) (credit to Graham Cox).
The original project used a local, hardcoded data layer. I wanted to expand on this to incorporate an actual database layer.

Since I personally use MySQL more, I have started a version of this demo using Liquibase and MySQL: [see here](https://github.com/mikebly/graphql-kotlin-mysql)

### Getting Started
- To get started, you can scaffold a project using SpringInitializr by starting a new Maven
 project and selecting the "Web" and "MongoDB" dependencies. You may have to upgrade your 
 Kotlin version to `1.3.31`
- Next, include the following dependencies in your `pom.xml`:
    - These will provide the tools necessary to implement GraphQL queries, mutations, and resolvers.
    - It will also allow the application to find schema files anywhere in the class-path
```
<dependency>
    <groupId>com.graphql-java-kickstart</groupId>
    <artifactId>graphql-spring-boot-starter</artifactId>
    <version>5.7.3</version>
</dependency>

<dependency>
    <groupId>com.graphql-java-kickstart</groupId>
    <artifactId>graphiql-spring-boot-starter</artifactId>
    <version>5.7.3</version>
    <scope>runtime</scope>
</dependency>

<dependency>
    <groupId>com.graphql-java-kickstart</groupId>
    <artifactId>graphql-java-tools</artifactId>
    <version>5.4.0</version>
</dependency>
```
- Define the database type and ports in `application.properties`:
```
server.port=8080
spring.data.mongodb.database=kotlin-graphql
spring.data.mongodb.port=27017
```
### Project Packages & Information
#### Packages
- `entities`: Data classes that represent the MongoDB collections
- `repositories`: Interfaces that represent the MongoDB repositories,
and their respective implementation classes
- `resolvers`: GraphQL resolver classes. Responsible for making queries and mutations
on the repositories
- `resources/graphql`: Holds schema files (`.graphqls`) that define the available queries and mutations
#### Other Info
- The function names defined in your query and mutation resolvers must match the names defined in your 
schema files 
- To test your GraphQL API, navigate to http://localhost:8080/graphiql
    - You will be able to write GraphQL queries and mutations from this dashboard
- Sample Queries and Mutations:
```
query{
  getPersonByName(name:"Bob"){
    id
    name
  }
}

mutation{
  addNewPerson(name: "Billy"){
    id,
    name
  }
}

mutation{
  addNewRelationship(from:"Billy",to:"Bob",relationship:"Friend"){
    from,
    to,
    relationship
  }
}

query{
  getPersonByName(name:"Billy"){
    id
    name
    relationships(type:"Friend"){
      to
    }
  }
}
```
