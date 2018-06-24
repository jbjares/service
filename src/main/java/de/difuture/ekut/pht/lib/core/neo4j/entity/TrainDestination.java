package de.difuture.ekut.pht.lib.core.neo4j.entity;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.*;
import java.util.stream.Collectors;


/**
 *  A TrainDestination is a node in a route for a particular train.
 *  It consists of the following attributes
 *
 *  * trainDestinationID. The internal ID for the Neo4j Persistence
 *  * routeID. The trainDestinationID of the route that this node belongs to. NodeIDs are train specific.
 *  * stationID. The ID of the station that this node addresses.
 *  * trainID. The ID of the train that this node belongs to
 *  * trainDockerRegistryURI the URI of the DockerTrainRegistry that this train belongs to
 *
 * @author Lukas Zimmermann
 */
@NodeEntity
@Getter
@Setter
public final class TrainDestination {

    @Id
    @GeneratedValue
    private Long trainDestinationID;

    @Relationship(type = "VISITS")
    private Station station;

    @Relationship(type = "OF_TRAIN")
    private Train train;

    @Relationship(type = "IS_CHILD_OF")
    private TrainDestination parent;

    @Relationship(type = "IS_PARENT_OF")
    private List<TrainDestination> children;

    // Whether this TrainDestination is a Root node.
    // A root node does not contain parents
    private boolean root;

    // Whether the station has reported to have this train visited
    private boolean hasBeenVisited;

    // Whether the station is ready to be visited
    private boolean canBeVisited;

    public TrainDestination() {

        this.children = new ArrayList<>();

        // Until added as a child
        this.root = true;
    }

    public TrainDestination(Station station, Train train) {

        this();
        this.station = station;
        this.train = train;
    }

    public static void link(TrainDestination source, TrainDestination target) {

        final List<TrainDestination> children = source.getChildren();

        final Set<Long> childrenIDs = children
                .stream()
                .map(TrainDestination::getTrainDestinationID)
                .collect(Collectors.toSet());

        if ( ! childrenIDs.contains(target.getTrainDestinationID())) {
            // Target is no longer a root node
            target.setRoot(false);
            children.add(target);
        }
        children.forEach(child -> child.setParent(source));
        source.setChildren(children);
    }
}
