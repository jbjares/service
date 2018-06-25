package de.difuture.ekut.pht.lib.core.datastructure

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIdentityReference
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import de.difuture.ekut.pht.lib.core.interfaces.BinaryRelation
import de.difuture.ekut.pht.lib.core.interfaces.Identifiable

data class Route(val nodes : Set<Node>, val edges : Set<Edge>) : Iterable<Route.Edge> {

    init {
        // Check that all the nodes in the edgeset are also contained in the node set
        val error = edges.any {

            it.source !in nodes || it.target !in nodes
        }
        if (error) {

            throw IllegalArgumentException("Edge set contains unknown nodes")
        }
    }
    override fun iterator() = this.edges.iterator()

    data class Edge(
            @JsonIdentityReference(alwaysAsId = true) val source : Node,
            @JsonIdentityReference(alwaysAsId = true) val target : Node)
        : BinaryRelation<Node, Node> {

        override fun getFirst() = this.source
        override fun getSecond() = this.target

        init {

            if (source == target) {

                throw IllegalArgumentException("Cannot create cyclic edge of node $source")
            }
        }
    }

    @JsonIdentityInfo(
            property = "id",
            generator = ObjectIdGenerators.PropertyGenerator::class)
    data class Node(val id : Long) : Identifiable {

            override fun getIdentifier() = this.id
    }


    /**
     * Contains helpers to quickly create routes
     */
    class Builder {

        private val edges : MutableSet<Route.Edge> = mutableSetOf()

        fun edge(from : Long, to : Long) : Builder {

            edges.add(
                    Route.Edge(Route.Node(from), Route.Node(to)))
            return this
        }

        fun build() : Route {

            val nodes = this.edges.map { setOf(it.source, it.target) }.flatten().toSet()
            return Route(nodes, this.edges)
        }
    }
}
