package converter;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import reactor.core.publisher.Flux;
import reactor.function.TupleUtils;
import structure.ListNode;

import java.lang.ref.Reference;
import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Jingxing Xu
 * @Date: 2019/9/14 18:45
 */
public class ListNodeConverter {

    public static ListNode toList(String string) {
        assertTrue(StringUtils.isNotBlank(string));
        ListNode list = new ListNode(Integer.MIN_VALUE);
        return Stream.of(StringUtils.split(string, "->"))
                .reduce(Pair.of(list, list),
                        (pair, val) -> {
                            assertFalse(StringUtils.isBlank(val));
                            ListNode head = pair.getLeft();
                            ListNode tail = pair.getRight();
                            if (head.val == Integer.MIN_VALUE) {
                                head.val = Integer.parseInt(val);
                                return pair;
                            } else {
                                ListNode insertNode = new ListNode(Integer.parseInt(val));
                                tail.next = insertNode;
                                return Pair.of(head, insertNode);
                            }
                        }, (head, tail) -> {
                            head.getRight().next = tail.getLeft();
                            return Pair.of(head.getLeft(), tail.getRight());
                        })
                .getLeft();
    }

    public static String toString(ListNode list) {
        assertNotNull(list);
        Flux<ListNode> nodeFlux = Flux.generate(() -> list,
                (listNode, sink) -> {
                    if (listNode == null) {
                        sink.complete();
                        return null;
                    }
                    sink.next(listNode);
                    return listNode.next;
                });
        return nodeFlux.reduce("", (string, node) -> {
            assertNotNull(string);
            if (string.isEmpty()) {
                return String.valueOf(node.val);
            }
            return string.concat(String.format("->%s", node.val));
        }).block();
    }
}
