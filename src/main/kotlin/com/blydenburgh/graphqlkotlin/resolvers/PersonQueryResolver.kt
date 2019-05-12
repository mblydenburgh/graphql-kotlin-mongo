package com.blydenburgh.graphqlkotlin.resolvers

import com.blydenburgh.graphqlkotlin.entities.Person
import com.blydenburgh.graphqlkotlin.repositories.PersonRepositoryImpl
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class PersonQueryResolver(private val personRepositoryImpl: PersonRepositoryImpl):GraphQLQueryResolver {
    fun getPersonByName(name: String):List<Person>{
        return personRepositoryImpl.getPersonByName(name = name)
    }
}