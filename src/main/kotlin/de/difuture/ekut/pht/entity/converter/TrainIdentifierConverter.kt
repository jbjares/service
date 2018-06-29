package de.difuture.ekut.pht.entity.converter

import de.difuture.ekut.pht.api.TrainIdentifier
import org.neo4j.ogm.typeconversion.CompositeAttributeConverter
import java.net.URI


class TrainIdentifierConverter : CompositeAttributeConverter<TrainIdentifier> {


    companion object {

        private const val KEY_REPOSITORY = "repository"
        private const val KEY_REGISTRY_URI = "registryURI"
    }

    override fun toGraphProperties(value: TrainIdentifier?): MutableMap<String, *> {

        val result : MutableMap<String, String> = HashMap()
        if (value != null) {

            result[KEY_REPOSITORY] = value.repository
            result[KEY_REGISTRY_URI] = value.registryURI.toASCIIString()
        }
        return result
    }

    override fun toEntityAttribute(value: MutableMap<String, *>?): TrainIdentifier? {

        // map is null or at least one of the keys is missing
        if (value == null || KEY_REPOSITORY !in value.keys || KEY_REGISTRY_URI !in value.keys) {

            return null
        }
        val repo = value[KEY_REPOSITORY].toString()
        val uri  = value[KEY_REGISTRY_URI].toString()

        if (repo.isBlank() || uri.isBlank()) {

            return null
        }

        // URI
        return try {
            TrainIdentifier(URI.create(uri), repo)
        } catch (e : Exception) {
            return null
        }
    }
}
