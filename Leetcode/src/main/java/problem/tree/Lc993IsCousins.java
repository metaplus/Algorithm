package problem.tree;

import problem.tree.node.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Lc993IsCousins {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (Objects.isNull(root)) {
            return false;
        }
        Deque<Cell> deque = new ArrayDeque<>();
        deque.offer(new Cell(root, -1));
        while (!deque.isEmpty()) {
            int size = deque.size();
            Cell pre = null;
            for (int i = 0; i < size; i++) {
                Cell cell = deque.poll();
                if (cell.node.val == x || cell.node.val == y) {
                    if (Objects.isNull(pre)) {
                        pre = cell;
                    } else {
                        return pre.parent != cell.parent;
                    }
                }
                if (Objects.nonNull(cell.node.left)) {
                    deque.offer(new Cell(cell.node.left, cell.node.val));
                }
                if (Objects.nonNull(cell.node.right)) {
                    deque.offer(new Cell(cell.node.right, cell.node.val));
                }
            }
            if (Objects.nonNull(pre)) {
                return false;
            }
        }
        return false;
    }

    class Cell {

        TreeNode node;
        int parent;

        public Cell(TreeNode node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
}
