package com.blydenburgh.graphqlkotlin.entities

import org.springframework.data.mongodb.core.mapping.Document

@Document("relationships")
data class Relationship(
        val from: String,
        val to: String,
        val relationship: String
)
