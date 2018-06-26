package de.difuture.ekut.pht.controller

import de.difuture.ekut.pht.api.StationPing
import de.difuture.ekut.pht.service.StationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@CrossOrigin
@RestController
@RequestMapping("/station")
class StationController @Autowired
constructor(private val stationService: StationService) {

    @RequestMapping(method = [RequestMethod.POST])
    @ResponseStatus(HttpStatus.OK)
    fun ping(@RequestBody @Valid stationPing: StationPing) {


    }



}
