package de.difuture.ekut.pht.lib.api.rest

import java.net.URI

class Station(
        /**
         * The global ID of the station. Knowledge of this ID is required for
         * purpose of communicating with RESTful services about this station.
         *
         */
        val stationID : Long,

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
