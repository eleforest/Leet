package eleforest.leet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;

import static eleforest.leet.LevelTraverseBinaryTree.levelTraverse;
import static eleforest.leet.BitReverseTimes.bitReverseTimesCalc;

class LeetTest {
    @Test
    void testLevelTravers(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<TreeNode> levelList = levelTraverse(root);
        levelList.stream().forEach(a -> System.out.println(a.val));
    }

    @Test
    void testReverseBit(){
        Assertions.assertEquals(0, bitReverseTimesCalc(13,3,15));
        Assertions.assertEquals(3, bitReverseTimesCalc(13,3,8));
        Assertions.assertEquals(1, bitReverseTimesCalc(12,2,15));
        Assertions.assertEquals(0, bitReverseTimesCalc(-1,1,-1));
        Assertions.assertEquals(0, bitReverseTimesCalc(-1,2,-1));
        Assertions.assertEquals(1, bitReverseTimesCalc(-2,2,-1));
        Assertions.assertEquals(1, bitReverseTimesCalc(-2,8,-7));
    }
}