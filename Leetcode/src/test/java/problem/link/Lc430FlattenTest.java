package problem.link;

import org.junit.jupiter.api.Test;
import problem.link.Lc430Flatten.Node;

class Lc430FlattenTest {

    @Test
    void flatten() {
        Node node = new Node(1, null, null,
                new Node(2, null, null,
                        new Node(3, null, null, null)));

        new Lc430Flatten().flatten(node);
    }
}