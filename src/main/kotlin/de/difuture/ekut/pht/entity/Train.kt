package de.difuture.ekut.pht.entity

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Id


@NodeEntity
class Train {

    @Id @GeneratedValue
    var id: Long? = null
    private set
}
