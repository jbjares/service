package de.difuture.ekut.pht.repository

import de.difuture.ekut.pht.entity.Node
import de.difuture.ekut.pht.entity.Route
import org.springframework.data.neo4j.annotation.Query
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.repository.query.Param

interface RouteRepository : Neo4jRepository<Route, Long> {

    @Query(" MATCH (r:Route)-[:STARTS_AT]->(x)-[:IS_PARENT_OF*]->(y)\n" +
            " WHERE ID(r)={routeID}\n" +
            " WITH collect(x) as parents, collect(y) as children\n" +
            " UNWIND parents + children as ids\n" +
            " RETURN collect(distinct ids)")
    fun getTrainDestinationIDs(@Param("routeID") routeID: Long?): List<Node>
}
