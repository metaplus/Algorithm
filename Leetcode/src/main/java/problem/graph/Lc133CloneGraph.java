package problem.graph;

import problem.graph.node.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Lc133CloneGraph {

    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (Objects.isNull(node)) {
            return null;
        }
        Node clone = map.get(node);
        if (Objects.nonNull(clone)) {
            return clone;
        }
        clone = new Node(node.val);
        map.put(node, clone);
        if (Objects.nonNull(node.neighbors)) {
            clone.neighbors = new ArrayList<>(node.neighbors.size());
            for (Node neighbor : node.neighbors) {
                clone.neighbors.add(cloneGraph(neighbor));
            }
        }
        return clone;
    }
}
