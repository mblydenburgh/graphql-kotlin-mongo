package com.blydenburgh.graphqlkotlin.repositories

import com.blydenburgh.graphqlkotlin.entities.Relationship
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface RelationshipRepository: MongoRepository<Relationship,String>