package de.difuture.ekut.pht.controller

import de.difuture.ekut.pht.api.StationPing
import de.difuture.ekut.pht.service.StationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("/station")
@CrossOrigin
class StationController
@Autowired constructor(private val stationService: StationService) {


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun ping(@RequestBody @Valid  stationPing: StationPing) {

        println("Station Controller has received ping")
        stationService.ensureStation(stationPing)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun get() : Iterable<URI> = this.stationService.findAll().map { it.uri}
}
