package de.difuture.ekut.pht.service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration
import org.springframework.boot.runApplication


@SpringBootApplication(
        exclude = [Neo4jDataAutoConfiguration::class])
class ServiceApplication

fun main(args: Array<String>) {
    runApplication<ServiceApplication>(*args)
}
