package problem.link.node;

import org.apache.commons.lang3.StringUtils;

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

    public static ListNode parseText(String text) {
        String[] tokens = StringUtils.split(StringUtils.strip(text, "[]"), ',');
        ListNode node = null;
        for (int i = tokens.length - 1; i >= 0; i--) {
            node = new ListNode(Integer.parseInt(tokens[i]), node);
        }
        return node;
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
}
