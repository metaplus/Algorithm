package problem.tree;

import org.junit.jupiter.api.Test;
import problem.tree.Lc297Codec.Codec;
import problem.tree.node.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc297CodecTest {

    @Test
    void codec() {
        TreeNode node = TreeNode.parse("[1,2,3,null,null,4,5]");
        Codec codec = new Codec();
        assertEquals(node, codec.deserialize(codec.serialize(node)));
    }
}