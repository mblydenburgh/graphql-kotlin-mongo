package com.blydenburgh.graphqlkotlin.entities

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "people")
data class Person(
        val id: String,
        val name: String
)