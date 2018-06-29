package de.difuture.ekut.pht

import de.difuture.ekut.pht.config.Neo4jConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories


@SpringBootApplication(
        exclude = [Neo4jDataAutoConfiguration::class])
@EnableNeo4jRepositories
@Import(Neo4jConfig::class)
class ServiceApplication

fun main(args: Array<String>) {
    runApplication<ServiceApplication>(*args)
}
