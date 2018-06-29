package de.difuture.ekut.pht.entity

import de.difuture.ekut.pht.entity.converter.URIConverter
import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.typeconversion.Convert
import java.net.URI

@NodeEntity
data class Station(

        @Convert(URIConverter::class)
        var uri  : URI? = null
) {

    @Id @GeneratedValue
    var stationID: Long? = null
}
