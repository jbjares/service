package de.difuture.ekut.pht.api

import com.fasterxml.jackson.annotation.JsonProperty

/**
 *
 * @author Lukas Zimmermann
 */
data class TrainNode(

        @JsonProperty("trainId") val trainId : Long,
        @JsonProperty("id") val nodeId : Long
)
