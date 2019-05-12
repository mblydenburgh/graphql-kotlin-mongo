package com.blydenburgh.graphqlkotlin.repositories

import com.blydenburgh.graphqlkotlin.entities.Person
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: MongoRepository<Person,String>