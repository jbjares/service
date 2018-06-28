package de.difuture.ekut.pht.service

import de.difuture.ekut.pht.api.StationPing
import de.difuture.ekut.pht.entity.Station
import de.difuture.ekut.pht.repository.StationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StationService
@Autowired constructor(private val stationRepository: StationRepository ) {

    fun ensureStation(stationPing: StationPing) : Station {

        val uri = stationPing.uri
        return stationRepository.findByUri(uri)?.let { it } ?: stationRepository.save(Station(uri))
    }

    fun findAll() : Iterable<Station> = this.stationRepository.findAll()
}
