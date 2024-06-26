package eleforest.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxPathSumBinaryTreeTest {
    @Test
    void testMaxPathSumTraverse() {
        Integer [] root = {-10,9,20,null,null,15,7};
        Assertions.assertEquals(42, MaxPathSumBinaryTree.MaxPathSumTraverse(root));
        
    }
    @Test
    void testSingleNode(){
        Integer [] root1 = {-10};
        Assertions.assertEquals(-10, MaxPathSumBinaryTree.MaxPathSumTraverse(root1));
    }

    @Test
    void test2() {
        Integer [] root = {-10,9,20,null,15,15,7};
        Assertions.assertEquals(49, MaxPathSumBinaryTree.MaxPathSumTraverse(root));
        
    }
}

