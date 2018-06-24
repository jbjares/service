package core.rest;


import core.datastructure.Route;


/**
 * Simple Model for a trainRoute. This restapi is a simplified version
 * of the data api used in Cytoscape
 *
 * @author Lukas Zimmermann
 *
 */
@Value
public class APIRoute {

    @JsonProperty("routeID")
    @NotNull
    Long routeID;

    @JsonProperty("route")
    @NotNull
    Route route;
}
