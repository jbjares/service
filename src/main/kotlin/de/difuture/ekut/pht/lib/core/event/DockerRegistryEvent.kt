package de.difuture.ekut.pht.lib.core.event

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI
import java.net.URL
import java.util.*

data class DockerRegistryEvent(

        @JsonProperty("id") val id : UUID,
        @JsonProperty("action") val action : Action,
        @JsonProperty("target") val target : Target,
        @JsonProperty("request") val request : Request,
        @JsonProperty("source") val source : Source) : Event {

    enum class Action {
        PULL, PUSH, MOUNT;

        companion object {

            @JsonCreator @JvmStatic
            fun fromString(value : String) : Action = Action.valueOf(value.trim().toUpperCase())
        }
    }

    data class Target(
            @JsonProperty("mediaType") val mediaType : String,
            @JsonProperty("size") val size : Int,
            @JsonProperty("digest") val digest : String,
            @JsonProperty("repository") val repository : String,
            @JsonProperty("url") val url : URL,
            @JsonProperty("tag") val tag : String?
    )

    data class Request(
            @JsonProperty("id") val id : String,
            @JsonProperty("addr") val addr : String,
            @JsonProperty("host") val host : URI,
            @JsonProperty("method") val method : String,
            @JsonProperty("useragent") val useragent : String
    )

    data class Source(
            @JsonProperty("addr") val addr : String,
            @JsonProperty("instanceID") val instanceID : String
    )
}
