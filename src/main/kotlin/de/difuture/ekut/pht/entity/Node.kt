package de.difuture.ekut.pht.entity

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship


@NodeEntity
class Node(

        @Relationship(type = "OF_TRAIN")
        val train: Train
) {

    @Id @GeneratedValue
    var id: Long? = null
    private set
}
