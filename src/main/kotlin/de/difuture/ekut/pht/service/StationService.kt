package de.difuture.ekut.pht.service

import de.difuture.ekut.pht.repository.StationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StationService
@Autowired constructor(private val stationRepository: StationRepository ) {


}
