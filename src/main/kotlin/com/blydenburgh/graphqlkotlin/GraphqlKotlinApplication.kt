package com.blydenburgh.graphqlkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GraphqlKotlinApplication

fun main(args: Array<String>) {
    runApplication<GraphqlKotlinApplication>(*args)
}
