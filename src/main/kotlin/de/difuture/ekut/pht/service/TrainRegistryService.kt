package de.difuture.ekut.pht.service

import de.difuture.ekut.pht.api.TrainIdentifier
import de.difuture.ekut.pht.lib.core.event.DockerRegistryEvent
import org.springframework.stereotype.Service


@Service
class TrainRegistryService {

    fun asIdentifier(event : DockerRegistryEvent) = TrainIdentifier(

            event.request.host, event.target.repository
    )

    /** Tests whether the DockerRegistryEvent is a PUSH event with a tag
     */
    private fun isPushEvent(event: DockerRegistryEvent) : Boolean
            = event.action === DockerRegistryEvent.Action.PUSH && event.target.tag != null


    /**
     * Filters all the events out that er are not interested in. The following filter logic applies:
     *
     *  - Currently, we only care for push events with a tag
     */
    fun filter(events: Iterable<DockerRegistryEvent>) = events.filter(this::isPushEvent)
}
