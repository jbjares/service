package de.difuture.ekut.pht.entity

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship


@NodeEntity
class Route(

        @Relationship(type = "BELONGS_TO")
        val train: Train
) {
    @Id @GeneratedValue
    var routeID: Long? = null

    // The Root APITrain Destinations of this route
    @Relationship(type = "STARTS_AT")
    private var starts: List<Node> = arrayListOf()
}
