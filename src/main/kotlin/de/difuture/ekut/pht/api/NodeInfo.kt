package de.difuture.ekut.pht.api

import java.net.URI


data class NodeInfo(

        val nodeId : Long,
        val nodeVisitState: NodeVisitState,
        val trainRegistryURI : URI,
        val trainID : Long,
        val stationName : String
)
