package core.rest;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.net.URI;

/**
 *
 * Represents a minimal response of an RESTful API that is supposed to return station
 * entities.
 *
 * @author Lukas Zimmermann
 */
@Value
public class APIStation {

    /**
     *  The global ID of the station. Knowledge of this ID is required for
     *  purpose of communicating with RESTful services about this station.
     *
     */
    @JsonProperty("stationID")
    @NotNull
    Long stationID;

    /**
     * The clear text name of this station.
     */
    @JsonProperty("stationName")
    @NotNull
    String stationName;

    /**
     *  The URI of this station. Communication with the station in the context of the
     *  Personal Health Train infrastructure must be performed using this station URI.
     */
    @JsonProperty("stationURI")
    @NotNull
    URI stationURI;
}
