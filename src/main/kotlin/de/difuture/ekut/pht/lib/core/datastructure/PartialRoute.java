package core.datastructure;

import java.util.HashSet;
import java.util.Set;

@Value
public class PartialRoute {

    @Getter(AccessLevel.NONE)
    Set<Route.Edge> edges;

    PartialRoute() {

        this.edges = new HashSet<>();
    }

    public PartialRoute edge(Long source, Long target) {

        this.edges.add(new Route.Edge(
                new Route.Node(source),
                new Route.Node(target)
        ));
        return this;
    }

    public Route build() {

        final Set<Route.Node> nodes = new HashSet<>();

        for (final Route.Edge edge : this.edges) {

            nodes.add(edge.getSource());
            nodes.add(edge.getTarget());
        }

        // Route constructor must make defensive copies of sets, such
        // that changing this PartialRoute does not change the constructed Route.
        return new Route(nodes, this.edges);
    }
}
