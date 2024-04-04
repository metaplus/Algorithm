package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc297Codec {

    public static class Codec {

        private int id = 0;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            dfs(root, builder, 0, true);
            return builder.toString();
        }

        private void dfs(TreeNode node, StringBuilder builder, int parent, boolean left) {
            if (Objects.isNull(node)) {
                return;
            }
            int nodeId = ++id;
            builder.append(node.val)
                    .append(',')
                    .append(nodeId)
                    .append(',')
                    .append(left ? -parent : parent)
                    .append('&');
            dfs(node.left, builder, nodeId, true);
            dfs(node.right, builder, nodeId, false);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (Objects.isNull(data) || data.isEmpty()) {
                return null;
            }
            String[] splits = data.split("&");
            TreeNode[] nodes = new TreeNode[splits.length + 1];
            for (String split : splits) {
                String[] arr = split.split(",");
                TreeNode node = new TreeNode(Integer.parseInt(arr[0]));
                nodes[Integer.parseInt(arr[1])] = node;
                int parent = Integer.parseInt(arr[2]);
                if (parent < 0) {
                    nodes[-parent].left = node;
                }
                if (parent > 0) {
                    nodes[parent].right = node;
                }
            }
            return nodes[1];
        }
    }
}
