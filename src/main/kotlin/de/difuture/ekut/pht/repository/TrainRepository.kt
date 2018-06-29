package de.difuture.ekut.pht.repository

import de.difuture.ekut.pht.api.TrainIdentifier
import de.difuture.ekut.pht.entity.Train
import org.springframework.data.neo4j.repository.Neo4jRepository

interface TrainRepository : Neo4jRepository<Train, Long> {

    fun findByIdentifier(identifier: TrainIdentifier) : List<Train>
}
