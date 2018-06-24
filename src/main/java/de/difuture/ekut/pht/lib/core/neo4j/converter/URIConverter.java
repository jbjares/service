package de.difuture.ekut.pht.lib.core.neo4j.converter;

import org.neo4j.ogm.typeconversion.AttributeConverter;

import java.net.URI;


/**
 *
 * @author Lukas Zimmermann
 */
public final class URIConverter implements AttributeConverter<URI, String> {

    private static final String NA = "NA";

    @Override
    public String toGraphProperty(URI value) {

        if (value == null) {

            return NA;
        }
        return value.toASCIIString();
    }

    @Override
    public URI toEntityAttribute(String value) {

        if (value == null || NA.equals(value)) {

            return null;
        }
        return URI.create(value);
    }
}
