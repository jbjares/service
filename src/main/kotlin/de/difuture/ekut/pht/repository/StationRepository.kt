package de.difuture.ekut.pht.repository

import de.difuture.ekut.pht.entity.Station
import org.springframework.data.neo4j.repository.Neo4jRepository
import java.net.URI
import java.util.*

interface StationRepository : Neo4jRepository<Station, UUID> {

    fun findByUri(uri: URI) : Station?
}
