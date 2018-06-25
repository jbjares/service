package de.difuture.ekut.pht.entity

import de.difuture.ekut.pht.lib.core.neo4j.converter.URIConverter
import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.NodeEntity
import java.net.URI
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.Relationship
import org.neo4j.ogm.annotation.typeconversion.Convert


@NodeEntity
class Train {

    @Id @GeneratedValue
    var trainID: Long? = null

    @Convert(URIConverter::class)
    var trainRegistryURI: URI? = null

    @Relationship(type = "HAS_ROUTE")
    var routes: List<Route> = arrayListOf()
}
