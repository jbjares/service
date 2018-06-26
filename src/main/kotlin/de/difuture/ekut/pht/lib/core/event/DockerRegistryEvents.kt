package de.difuture.ekut.pht.lib.core.event

import com.fasterxml.jackson.annotation.JsonProperty

data class DockerRegistryEvents (
        @JsonProperty("events") val events : Iterable<DockerRegistryEvent>
) : Iterable<DockerRegistryEvent> {

    override fun iterator(): Iterator<DockerRegistryEvent> = this.events.iterator()
}
