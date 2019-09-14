package converter;

import base.AlgorithmTestBase;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import structure.ListNode;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Jingxing Xu
 * @Date: 2019/9/14 19:40
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ListNodeConverterTest extends AlgorithmTestBase {

    ListNode node;
    String string;

    @Order(1)
    @Test
    void toList() {
        string = "1->2->3";
        node = ListNodeConverter.toList(string);
    }

    @Order(2)
    @Test
    void testToString() {
        assertNotNull(node);
        assertEquals(ListNodeConverter.toString(node), string);
    }
}