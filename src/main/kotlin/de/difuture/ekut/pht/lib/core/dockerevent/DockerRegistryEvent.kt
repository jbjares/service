package de.difuture.ekut.pht.lib.core.dockerevent

import java.net.URI
import java.net.URL
import java.util.*


data class DockerRegistryEvent(

    val id : UUID,
    val action : Action,
    val target : Target,
    val request : Request,
    val source : Source) {

    enum class Action {
        PULL, PUSH, MOUNT
    }

    data class Target(
        val mediaType : String,
        val size : Int,
        val digest : String,
        val repository : String,
        val url : URL,
        val tag : String
    )

    data class Request(
        val id : String,
        val addr : String,
        val host : URI,
        val method : String,
        val useragent : String
    )

    data class Source(
        val addr : String,
        val instanceID : String
    )
}
