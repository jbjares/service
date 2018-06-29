package de.difuture.ekut.pht.entity.converter

import de.difuture.ekut.pht.api.TrainIdentifier
import de.difuture.ekut.pht.lib.core.constants.NA
import org.neo4j.ogm.typeconversion.AttributeConverter
import java.net.URI


class TrainIdentifierConverter : AttributeConverter<TrainIdentifier, String> {


    companion object {

        // Because $ is invalid in URIs and repository names
        const val sep = "$"
    }

    override fun toGraphProperty(value: TrainIdentifier?): String {

        if (value == null) {

            return NA
        }
        return value.registryURI.toASCIIString() + sep + value.repository
    }

    override fun toEntityAttribute(value: String?): TrainIdentifier? {

        if (value == null) {

            return null
        }
         val spt = value.split("$")

        if (spt.size != 2) {

            return null
        }
        return try {TrainIdentifier(URI.create(spt[0]), spt[1]) } catch (e : Exception) { null }
    }
}
