package de.difuture.ekut.pht.test

import de.difuture.ekut.pht.lib.core.dockerevent.DockerRegistryEvent
import de.difuture.ekut.pht.service.eventconsumer.RegistryEventConsumer
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("test")
class TestConsumer : RegistryEventConsumer {

    override fun consume(event: DockerRegistryEvent) {

        println(event)
    }
}