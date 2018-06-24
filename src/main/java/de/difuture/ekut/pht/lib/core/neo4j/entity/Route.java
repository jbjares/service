package de.difuture.ekut.pht.lib.core.neo4j.entity;


import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Lukas Zimmermann
 */
@NodeEntity
@Getter
@Setter
public final class Route {

    @Id
    @GeneratedValue
    private Long routeID;

    @Relationship(type = "BELONGS_TO")
    private Train train;

    // The Root APITrain Destinations of this route
    @Relationship(type = "STARTS_AT")
    private List<TrainDestination> starts;

    public Route() {

        this.starts = new ArrayList<>();
    }

    public Route(@NotNull Train train) {

        this();
        this.train = train;
    }
}
