package problem.link.node;

import org.apache.commons.lang3.StringUtils;
import problem.array.parse.ArrayParse;

import java.util.Objects;
import java.util.StringJoiner;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode parse(String text) {
        String[] tokens = StringUtils.split(StringUtils.strip(text, "[]"), ',');
        ListNode node = null;
        for (int i = tokens.length - 1; i >= 0; i--) {
            node = new ListNode(Integer.parseInt(tokens[i]), node);
        }
        return node;
    }

    public static ListNode[] parse2Dim(String text) {
        int[][] array = ArrayParse.parse2DIntArray(text);
        ListNode[] nodes = new ListNode[array.length];
        for (int i = 0; i < array.length; i++) {
            ListNode node = null;
            for (int j = array[i].length - 1; j >= 0; j--) {
                node = new ListNode(array[i][j], node);
            }
            nodes[i] = node;
        }
        return nodes;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" -> ", "[ ", " ]");
        ListNode node = this;
        while (Objects.nonNull(node)) {
            joiner.add(Integer.toString(node.val));
            node = node.next;
        }
        return joiner.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListNode node = (ListNode) o;

        if (val != node.val) return false;
        return Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }
}
