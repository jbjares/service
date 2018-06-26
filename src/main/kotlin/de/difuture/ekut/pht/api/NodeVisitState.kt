package de.difuture.ekut.pht.api

enum class NodeVisitState {

    ROOT_UNVISITED,
    ROOT_VISITED,
    CHILD_UNSATISFIED,
    CHILD_SATISFIED,
    CHILD_VISITED
}
