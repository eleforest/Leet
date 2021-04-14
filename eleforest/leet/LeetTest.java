package eleforest.leet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.util.List;

import static eleforest.leet.LevelTraverseBinaryTree.levelTraverse;
import static eleforest.leet.BitReverseTimes.bitReverseTimesCalc;
import static eleforest.leet.QueueGetFood.calcTime2Food;

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
        levelList.forEach(a -> System.out.println(a.val));
    }

    @Test
    void testReverseBit(){
        Assertions.assertEquals(0, bitReverseTimesCalc(13,3,15));
        Assertions.assertEquals(4, bitReverseTimesCalc(13,3,8));
        Assertions.assertEquals(1, bitReverseTimesCalc(12,2,15));
        Assertions.assertEquals(0, bitReverseTimesCalc(-1,1,-1));
        Assertions.assertEquals(0, bitReverseTimesCalc(-1,2,-1));
        Assertions.assertEquals(1, bitReverseTimesCalc(-2,2,-1));
        Assertions.assertEquals(3, bitReverseTimesCalc(-2,8,-7));
        Assertions.assertEquals(31, bitReverseTimesCalc(-2,8,7));
        Assertions.assertEquals(3, bitReverseTimesCalc(2,6,5));
        Assertions.assertEquals(0, bitReverseTimesCalc(1,2,3));
    }

    @Test
    void testQueue2GetFood(){
        ByteArrayInputStream bais = new ByteArrayInputStream("3\n1 5\n1 1\n2 4\n".getBytes());
        Assertions.assertEquals("1 0 3 ",calcTime2Food(bais));
        bais = new ByteArrayInputStream("2\n1 3\n1 4\n".getBytes());
        Assertions.assertEquals("1 2 ",calcTime2Food(bais));
    }
}