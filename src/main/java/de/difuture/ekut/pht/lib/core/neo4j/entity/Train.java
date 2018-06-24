package de.difuture.ekut.pht.lib.core.neo4j.entity;


import de.difuture.ekut.pht.lib.core.restapi.APITrain;
import de.difuture.ekut.pht.lib.core.neo4j.converter.URIConverter;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.Convert;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Lukas Zimmermann
 */
@NodeEntity
@Getter
@Setter
public final class Train {

    @Id
    @GeneratedValue
    private Long trainID;

    @Convert(URIConverter.class)
    private URI trainRegistryURI;

    @Relationship(type = "HAS_ROUTE")
    private List<Route> routes;

    public Train() {

        this.routes = new ArrayList<>();
    }

    public APITrain toTrain() {

        return new APITrain(this.trainID, this.trainRegistryURI);
    }
}
