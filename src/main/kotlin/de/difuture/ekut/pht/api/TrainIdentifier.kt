package de.difuture.ekut.pht.api

import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI


/**
 *
 * A train is currently identified by the originating registry and
 * the String for the repository
 *
 */
data class TrainIdentifier(

        @JsonProperty("registryURI") val registryURI : URI,
        @JsonProperty("repository") val repository : String
)
