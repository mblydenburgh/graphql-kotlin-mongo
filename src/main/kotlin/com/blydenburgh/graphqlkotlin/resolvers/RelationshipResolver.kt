package com.blydenburgh.graphqlkotlin.resolvers

import com.blydenburgh.graphqlkotlin.entities.Person
import com.blydenburgh.graphqlkotlin.entities.Relationship
import com.blydenburgh.graphqlkotlin.repositories.PersonRepositoryImpl
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class RelationshipResolver(private val personRepositoryImpl: PersonRepositoryImpl):GraphQLResolver<Relationship> {
    fun getFrom(relationship: Relationship):List<Person>{
        return personRepositoryImpl.getPersonByName(relationship.from)
    }

    fun getTo(relationship: Relationship):List<Person>{
    return personRepositoryImpl.getPersonByName(relationship.to)
    }
}