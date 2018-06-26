package de.difuture.ekut.pht.repository

import de.difuture.ekut.pht.entity.Node
import org.springframework.data.neo4j.repository.Neo4jRepository

interface NodeRepository : Neo4jRepository<Node, Long> {

    /**
     * This query is used for regularly publishing train visit messages
     *
     */
//    @Depth(2)
//    fun findAllByCanBeVisitedIsTrueAndHasBeenVisitedIsFalse(): List<Node>

    /**
     * These nodes can be processed, because these nodes are Root nodes.
     * But the train is not available.
     */
//    // TODO Might be necessary to update this regularly
//    fun findAllByRootIsTrueAndCanBeVisitedIsFalse(): List<Node>
}
