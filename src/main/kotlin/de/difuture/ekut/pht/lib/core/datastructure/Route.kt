package de.difuture.ekut.pht.lib.core.datastructure

import com.fasterxml.jackson.annotation.*
import de.difuture.ekut.pht.lib.core.interfaces.BinaryRelation
import de.difuture.ekut.pht.lib.core.interfaces.Identifiable

data class Route(
        @JsonProperty("nodes")
        val nodes : Set<Node>,

        @JsonProperty("edges")
        val edges : Set<Edge>) : Iterable<Route.Edge> {

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
            @JsonProperty("source")
            @JsonIdentityReference(alwaysAsId = true)
            val source : Node,

            @JsonProperty("target")
            @JsonIdentityReference(alwaysAsId = true)
            val target : Node)
        : BinaryRelation<Node, Node> {

        @JsonIgnore
        override fun getFirst() = this.source

        @JsonIgnore
        override fun getSecond() = this.target

        constructor(source : Long, target : Long) : this(Node(source), Node(target))

        init {

            if (source == target) {

                throw IllegalArgumentException("Cannot create cyclic edge of node $source")
            }
        }
    }

    @JsonIdentityInfo(
            property = "id",
            generator = ObjectIdGenerators.PropertyGenerator::class)
    data class Node(
            @JsonProperty("id") val id : Long) : Identifiable {

            @JsonIgnore
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
