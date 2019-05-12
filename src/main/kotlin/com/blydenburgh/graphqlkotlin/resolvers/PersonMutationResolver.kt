package com.blydenburgh.graphqlkotlin.resolvers

import com.blydenburgh.graphqlkotlin.entities.Person
import com.blydenburgh.graphqlkotlin.repositories.PersonRepositoryImpl
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class PersonMutationResolver(private val personRepositoryImpl: PersonRepositoryImpl): GraphQLMutationResolver {
    fun addNewPerson(name: String): Person{
        return personRepositoryImpl.addPerson(name = name)
    }
}