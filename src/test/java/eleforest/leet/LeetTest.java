package eleforest.leet;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.util.List;

import static eleforest.leet.LevelTraverseBinaryTree.levelTraverse;
import static eleforest.leet.BitReverseTimes.bitReverseTimesCalc;
import static eleforest.leet.MaxProfit.maxProfit;
import static eleforest.leet.QueueGetFood.calcTime2Food;
import static eleforest.leet.StepOneTwo.stepOneTwo;
import static eleforest.leet.SymmetryBinaryTree.*;
import static eleforest.leet.MinArrayDifferenceSum.minDifference;

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

    @Test
    void testStepOneTwo(){
        ByteArrayInputStream bais = new ByteArrayInputStream("2\n3\n0 2 4\n3\n0 4 2\n".getBytes());
        Assertions.assertEquals("4 3 ", stepOneTwo(bais));
        bais = new ByteArrayInputStream("1\n5\n0 2 4 2 3\n".getBytes());
        Assertions.assertEquals("7 ", stepOneTwo(bais));
    }

    @Test
    void testMaxProfit(){
        int [] seq = new int[] {4,4,6,1,1,4,5};
        Assertions.assertEquals(6, maxProfit(seq));
        seq = new int[] {1,2,3,4,5,6,7};
        Assertions.assertEquals(6, maxProfit(seq));
        seq = new int[] {7,6,5,4,3,2,1};
        Assertions.assertEquals(0, maxProfit(seq));
        seq = new int[] {1,2,3,2,5,1,7};
        Assertions.assertEquals(11, maxProfit(seq));
        seq = new int[] {1};
        Assertions.assertEquals(0, maxProfit(seq));

    }

    @Test
    void testSymmetryTree(){
        int[] preOrd = new int[]{0, 1, 2, 3};
        int[] inOrd = new int[]{2, 1, 3, 0};
        int[] weight = new int[]{1, 2, 4, 4};
        Assertions.assertEquals(10, maxWeight(preOrd,inOrd,weight));
        preOrd = new int[]{0, 1, 2, 3, 4, 5, 6};
        inOrd = new int[]{2, 1, 3, 0, 5, 4, 6};
        weight = new int[]{1, 2, 4, 4, 2, 4, 4};
        Assertions.assertEquals(21, maxWeight(preOrd,inOrd,weight));
        preOrd = new int[]{0, 1, 2};
        inOrd = new int[]{2, 1, 0};
        weight = new int[]{1, 2, 8};
        Assertions.assertEquals(8, maxWeight(preOrd,inOrd,weight));
        // error
        preOrd = new int[]{0, 1, 2};
        inOrd = new int[]{3, 2, 3};
        weight = new int[]{1, 2, 8};
        Assertions.assertEquals(0, maxWeight(preOrd,inOrd,weight));

    }
    @Test
    void testMinArrayDifferenceSum(){
        Assertions.assertEquals(4, minDifference(3));
        Assertions.assertEquals(6, minDifference(5));
    }
}