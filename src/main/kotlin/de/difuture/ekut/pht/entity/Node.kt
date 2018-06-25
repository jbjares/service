package de.difuture.ekut.pht.entity

import de.difuture.ekut.pht.lib.core.interfaces.BinaryRelation
import de.difuture.ekut.pht.lib.core.interfaces.Identifiable
import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship
import java.util.function.BiFunction
import java.util.stream.Collectors


@NodeEntity
class Node private constructor(

        @Relationship(type = "OF_STATION")
        val station: Station,

        @Relationship(type = "OF_TRAIN")
        val train: Train,

        @Relationship(type = "IS_CHILD_OF")
        val parent: Node?,

        @Relationship(type = "IS_PARENT_OF")
        val children: List<Node>
) {

    @Id @GeneratedValue
    var nodeID: Long? = null

    // Whether this TrainDestination is a Root node.
    // A root node does not contain parent
    val root: Boolean = parent == null

    // Whether the station has reported to have this train visited
    var hasBeenVisited: Boolean = false

    // Whether the station is ready to be visited
    var canBeVisited: Boolean = false

    companion object {

        fun from(
                relations : Iterable<BinaryRelation<Identifiable, Identifiable>>,
                train : Train,
                station : Station) : Set<Node> {

            val relationMap : MutableMap<Long, Set<Long>> = HashMap()
            val roots : MutableMap<Long, Boolean>

            for (relation in relations) {

                val second = relation.getSecond().getIdentifier()
                

                relationMap.compute(relation.getFirst().getIdentifier()) { _, u ->

                    u?.plus(second) ?: setOf(second)
                }
            }




        }

    }

    fun link(source: TrainDestination, target: TrainDestination) {

        val children = source.getChildren()

        val childrenIDs = children
                .stream()
                .map(Function<TrainDestination, Long> { it.getTrainDestinationID() })
                .collect(Collectors.toSet<Long>())

        if (!childrenIDs.contains(target.trainDestinationID)) {
            // Target is no longer a root node
            target.isRoot = false
            children.add(target)
        }
        children.forEach { child -> child.parent = source }
        source.setChildren(children)
    }
}
}
