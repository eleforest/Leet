package eleforest.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumFromRoot2LeafTest {
    @Test
    void testSumTraverse() {
        int [] treeSeq = {4,9,0,5,1};
        TreeNode root = new TreeNode(treeSeq[0]);
        SumFromRoot2Leaf.genTree(treeSeq, 0, root);
        Assertions.assertEquals(1026, 
            SumFromRoot2Leaf.sumTraverse(root, 0));
    }

    @Test
    void testSumTraverse2() {
        int [] treeSeq = {1,2,3};
        TreeNode root = new TreeNode(treeSeq[0]);
        SumFromRoot2Leaf.genTree(treeSeq, 0, root);
        Assertions.assertEquals(25, 
            SumFromRoot2Leaf.sumTraverse(root, 0));
    }

    @Test
    void testSumTraverse3() {
        Assertions.assertEquals(-1, 
            SumFromRoot2Leaf.sumTraverse(null, 0));
    }
}
