package com.blydenburgh.graphqlkotlin.resolvers

import com.blydenburgh.graphqlkotlin.entities.Person
import com.blydenburgh.graphqlkotlin.repositories.RelationshipRepository
import com.blydenburgh.graphqlkotlin.repositories.RelationshipRepositoryImpl
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class PersonResolver(private val relationshipRepositoryImpl: RelationshipRepositoryImpl):GraphQLResolver<Person> {
    fun relationships(person: Person,type: String?) = when (type){
        null -> relationshipRepositoryImpl.getRelationshipsFromPerson(person.name)
        else -> relationshipRepositoryImpl.getRelationshipsOfTypeFromPerson(person.name,type)
    }
}