package de.difuture.ekut.pht.entity

import de.difuture.ekut.pht.lib.core.neo4j.converter.URIConverter
import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.typeconversion.Convert
import java.net.URI

@NodeEntity
class Station(

        val stationName : String,

        @Convert(URIConverter::class)
        val stationURI  : URI
) {

    @Id @GeneratedValue
    var stationID: Long? = null

    // Whether the station is considered to be active
    private var active: Boolean = false
}
