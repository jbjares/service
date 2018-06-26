package de.difuture.ekut.pht.lib.core.event

import java.net.URI

sealed class TrainEvent : Event
data class NewTrainCreated(val trainID : Long, val registryURI : URI) : TrainEvent()
data class TrainHasVisitedNode(val trainID : Long, val nodeID : Long) : TrainEvent()
