package de.difuture.ekut.pht.service.eventconsumer

import de.difuture.ekut.pht.lib.core.event.DockerRegistryEvent

interface RegistryEventConsumer {

    fun consume(event : DockerRegistryEvent)
}
