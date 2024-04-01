package problem.tree.node;

import problem.array.parse.ArrayParse;

import java.util.Objects;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode parse(String text) {
        Integer[] array = ArrayParse.parseIntegerArray(text);
        TreeNode[] nodes = new TreeNode[array.length];
        for (int i = 0; i < array.length; i++) {
            if(Objects.isNull(array[i])){
                continue;
            }
            nodes[i] = new TreeNode(array[i]);
            if (i > 0) {
                if (i % 2 == 1) {
                    nodes[(i - 1) / 2].left = nodes[i];
                } else {
                    nodes[(i - 1) / 2].right = nodes[i];
                }
            }
        }
        return nodes[0];
    }
}
