package de.difuture.ekut.pht.api

import java.net.URI

data class StationPing(

        /**
         * The clear text name of this station.
         */
        val stationName : String,

        /**
         * The URI of this station. Communication with the station in the context of the
         * Personal Health Train infrastructure must be performed using this station URI.
         */
        val stationURI : URI
)
