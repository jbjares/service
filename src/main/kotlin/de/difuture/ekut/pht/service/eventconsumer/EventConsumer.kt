package de.difuture.ekut.pht.service.eventconsumer

import de.difuture.ekut.pht.lib.core.event.DockerRegistryEvent
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service


@Service
@Profile("production")
class EventConsumer : RegistryEventConsumer {

    override fun consume(event: DockerRegistryEvent) {


    }
}
