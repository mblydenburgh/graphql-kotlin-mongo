package com.blydenburgh.graphqlkotlin.repositories

import com.blydenburgh.graphqlkotlin.entities.Relationship
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class RelationshipRepositoryImpl {

    @Autowired
    lateinit var repository: RelationshipRepository

    fun getRelationshipsFromPerson(name: String):List<Relationship>{
        val relationships = repository.findAll()
        return relationships.filter { relationship -> relationship.from == "name" }
    }

    fun getRelationshipsOfTypeFromPerson(personName:String, type: String): List<Relationship>{
        val relationships = repository.findAll()
        return relationships.filter { relationship -> relationship.from == personName }
                .filter { relationship -> relationship.relationship == type }
    }

    fun addRelationship(from: String, to: String, relationship: String): Relationship{
        val newRelationship =  Relationship(
                from = from,
                to = to,
                relationship = relationship
        )
        repository.save(newRelationship)
        return newRelationship
    }
}