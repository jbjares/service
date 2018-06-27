package de.difuture.ekut.pht.entity

import de.difuture.ekut.pht.entity.converter.URIConverter
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.typeconversion.Convert
import java.net.URI


@NodeEntity
data class TrainRegistry(

        @Convert(URIConverter::class)
        val uri : URI
)
