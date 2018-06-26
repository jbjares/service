package de.difuture.ekut.pht.controller

import de.difuture.ekut.pht.lib.core.event.DockerRegistryEvents
import de.difuture.ekut.pht.service.eventconsumer.RegistryEventConsumer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/listener")
class RegistryListenerController
@Autowired constructor(private val consumer: RegistryEventConsumer) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun listener(@RequestBody events: DockerRegistryEvents) {

        // Just print the events for testing purposes
        events.forEach { println(it) }
    }
}


// if (event.action === DockerRegistryEvent.Action.PUSH && tag != null)   TEST VALID