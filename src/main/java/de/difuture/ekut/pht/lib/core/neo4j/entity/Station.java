package de.difuture.ekut.pht.lib.core.neo4j.entity;


import de.difuture.ekut.pht.lib.core.restapi.APIStation;
import de.difuture.ekut.pht.lib.core.neo4j.converter.URIConverter;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.typeconversion.Convert;

import java.net.URI;
import java.time.Instant;


/**
 *
 *
 * @author Lukas Zimmermann
 */
@NodeEntity
@Data
@NoArgsConstructor
public final class Station {

    @Id
    @GeneratedValue
    private Long stationID;

    private String stationName;

    // When the station send the last ping to activate itself
    private Instant lastPing;

    // Whether the station is considered to be active
    private boolean active;

    // The public accessible URI of the station
    @Convert(URIConverter.class)
    private URI stationURI;

    public Station(
            final APIStation APIStation,
            final Instant lastPing) {

        this.stationURI = APIStation.getStationURI();
        this.lastPing = lastPing;
        this.stationName = APIStation.getStationName();
    }

    public APIStation toStation() {

        return new APIStation(this.stationID, this.stationName, this.stationURI);
    }
}
