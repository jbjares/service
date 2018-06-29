package de.difuture.ekut.pht.controller

import de.difuture.ekut.pht.lib.core.event.DockerRegistryEvents
import de.difuture.ekut.pht.service.TrainRegistryService
import de.difuture.ekut.pht.service.TrainService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/listener")
class RegistryListenerController
@Autowired constructor(
        private val trainRegistryService : TrainRegistryService,
        private val trainService: TrainService) {


    /**
     * Contains the logic on what needs to be done in the graph when an event in the docker registry occurs.
     *
     */
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun listener(@RequestBody events: DockerRegistryEvents) {

        for (event in trainRegistryService.filter(events)) {

            val trainIdentifier = trainRegistryService.asIdentifier(event)

            // Ensure that the train Exists in the database
            this.trainService.ensureTrain(trainIdentifier)
        }
    }
}
