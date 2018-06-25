package de.difuture.ekut.pht.lib.api.rest

import java.net.URI

data class Train(

        /**
         * The global ID of the train. Knowledge of this ID is required for the following purposes
         * (a) communication with a RESTful API to perform requests about this train.
         * (b) Communication with the Train Docker Registry hosting this particular train.
         * The repository name in this Docker Registry hosting versions of the train is
         * identical to this trainID.
         *
         */
        val trainID : Long,

        /**
         * The Docker Registry URI hosting this train. Each train can only be associated
         * with at most Train Docker Registry. This value can be null for (at least) two
         * reasons.
         *
         * (a) The train has not yet been associated with a Train Docker Registry.
         * (b) The services responding with objects of [APITrain] cannot determine
         * the URI of the Docker Train Registry containing this train.
         *
         */
        val trainRegistryURI : URI
)