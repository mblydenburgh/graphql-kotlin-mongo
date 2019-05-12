package com.blydenburgh.graphqlkotlin.resolvers

import com.blydenburgh.graphqlkotlin.entities.Relationship
import com.blydenburgh.graphqlkotlin.repositories.RelationshipRepositoryImpl
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class ReltionshipMutationResolver(private val relationshipRepositoryImpl: RelationshipRepositoryImpl): GraphQLMutationResolver {
    fun addNewRelationship(from: String, to: String, relationship: String): Relationship {
        return relationshipRepositoryImpl.addRelationship(
                from = from,
                to = to,
                relationship = relationship
        )
    }
}