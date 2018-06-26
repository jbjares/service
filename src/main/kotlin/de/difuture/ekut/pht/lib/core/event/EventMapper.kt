package de.difuture.ekut.pht.lib.core.event

interface EventMapper<A,B> where A : Event, B : Event {

    fun map(event : A) : B
}
