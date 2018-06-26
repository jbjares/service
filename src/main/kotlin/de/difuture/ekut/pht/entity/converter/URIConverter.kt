package de.difuture.ekut.pht.entity.converter

import de.difuture.ekut.pht.lib.core.constants.NA
import org.neo4j.ogm.typeconversion.AttributeConverter
import java.net.URI


class URIConverter : AttributeConverter<URI, String> {

    override fun toGraphProperty(value: URI?): String {

        return value?.toASCIIString() ?: NA
    }


    override fun toEntityAttribute(value: String?): URI? {

        return if (value == null || NA == value) {

            null

        } else URI.create(value)
    }
}
