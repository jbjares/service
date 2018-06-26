package de.difuture.ekut.pht.entity

import de.difuture.ekut.pht.api.NodeVisitState
import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship


@NodeEntity
class Node private constructor(

        @Relationship(type = "OF_STATION")
        val station: Station,

        @Relationship(type = "OF_TRAIN")
        val train: Train,

        @Relationship(type = "IS_CHILD_OF")
        val parent: Node?,

        @Relationship(type = "IS_PARENT_OF")
        val children: List<Node>,

        var state : NodeVisitState
) {

    @Id @GeneratedValue
    var nodeID: Long? = null

//    companion object {
//
//        fun from(
//                relations : Iterable<BinaryRelation<Identifiable, Identifiable>>,
//                train : Train,
//                station : Station) : Set<Node> {
//
//            val relationMap : MutableMap<Long, Set<Long>> = HashMap()
//            val roots : MutableMap<Long, Boolean>
//
//            for (relation in relations) {
//
//                val second = relation.getSecond().getIdentifier()
//                relationMap.compute(relation.getFirst().getIdentifier()) { _, u ->
//
//                    u?.plus(second) ?: setOf(second)
//                }
//            }
//        }
//    }
}
