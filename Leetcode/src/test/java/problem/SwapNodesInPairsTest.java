package problem;

import base.AlgorithmTestBase;
import converter.ListNodeConverter;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import structure.ListNode;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Jingxing Xu
 * @Date: 2019/9/14 18:44
 */
class SwapNodesInPairsTest extends AlgorithmTestBase<SwapNodesInPairs> {

    private Logger logger = LoggerFactory.getLogger(SwapNodesInPairsTest.class);

    @Test
    void swapPairs() {
        logger.info("swapPairs");
        Flux.just(Pair.of("1->2->3->4", "2->1->4->3"))
                .subscribe(pair -> {
                    String input = pair.getLeft();
                    String output = pair.getRight();
                    ListNode inputList = ListNodeConverter.toList(input);
                    ListNode outputList = algorithm.swapPairs(inputList);
                    String outputTest = ListNodeConverter.toString(outputList);
                    assertEquals(output, outputTest);
                });
    }
}