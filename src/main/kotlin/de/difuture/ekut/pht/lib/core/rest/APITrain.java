package core.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.net.URI;


/**
 *
 * Represents a minimal response of an RESTful API that is supposed to return train
 * entities.
 *
 * @author Lukas Zimmermann
 */
@Value
public class APITrain {

    /**
     *  The global ID of the train. Knowledge of this ID is required for the following purposes
     *  (a) communication with a RESTful API to perform requests about this train.
     *  (b) Communication with the Train Docker Registry hosting this particular train.
     *  The repository name in this Docker Registry hosting versions of the train is
     *  identical to this trainID.
     *
     */
    @JsonProperty("trainID")
    @NotNull
    Long trainID;

    /**
     *  The Docker Registry URI hosting this train. Each train can only be associated
     *  with at most Train Docker Registry. This value can be null for (at least) two
     *  reasons.
     *
     *  (a) The train has not yet been associated with a Train Docker Registry.
     *  (b) The services responding with objects of {@link APITrain} cannot determine
     *  the URI of the Docker Train Registry containing this train.
     *
     */
    @JsonProperty("trainRegistryURI")
    URI trainRegistryURI;


    /**
     * Returns whether this {@link APITrain} has a Train Registry URI.
     *
     *
     * @return Whether this {@link APITrain} has a Train Registry URI.
     */
    public boolean hasTrainRegistryURI() {

        return this.trainRegistryURI != null;
    }
}
