package com.blydenburgh.graphqlkotlin.repositories

import com.blydenburgh.graphqlkotlin.entities.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component
import java.util.*

@Component
class PersonRepositoryImpl(private val mongoOperations: MongoOperations) {
    @Autowired
    lateinit var repository: PersonRepository

//    fun getAllPeople():List<Person>{
//        return repository.findAll()
//    }

    fun getPersonByName(name: String):List<Person>{
        val query = Query()
        query.addCriteria(Criteria.where("name").`is`(name))
        return mongoOperations.find(query,Person::class.java)
    }

    fun addPerson(name: String):Person{
        val id = UUID.randomUUID().toString()
        val person = Person(name = name, id = id)
        repository.save(person)
        return person
    }
}