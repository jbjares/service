package core.datastructure;


import java.util.*;

data class Route() {

    Set<Node> nodes;

    Set<Edge> edges;

    public Route(Set<Node> nodes, Set<Edge> edges) {

        // defensive copy of arguments
        this.nodes = new HashSet<>(nodes);
        this.edges = new HashSet<>(edges);
        this.checkEdgeSet();
    }

    public Set<Node> getNodes() {

        return Collections.unmodifiableSet(this.nodes);
    }

    public Set<Edge> getEdges() {

        return Collections.unmodifiableSet(this.edges);
    }


    /**
     *  Checks that the Edge set does not contain any nodes that do not appear
     *  in the node set.
     *
     * @throws IllegalStateException When the EdgeSet contains nodes that the node set does not.
     */
    private void checkEdgeSet() {

        for (final Edge edge : this.edges) {

            final Node source = edge.getSource();
            final Node target = edge.getTarget();

            if ( ! this.nodes.contains(source)) {

                throw new IllegalStateException("Node set does not contain node: " + source.id);
            }

            if ( ! this.nodes.contains(target)) {

                throw new IllegalStateException("Node set does not contain node: " + target.id);
            }
        }
    }


    @Value
    public static final class Edge {

        @JsonProperty("source")
        @JsonIdentityReference(alwaysAsId = true)
        Node source;

        @JsonProperty("target")
        @JsonIdentityReference(alwaysAsId = true)
        Node target;
    }

    @Value
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    public static final class Node {

        @JsonProperty("id")
        Long id;
    }

}
