package eleforest.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * 124. 二叉树中的最大路径和 困难
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 
 * 例子1：
 *       1
 *     2   3  最大路径 2->1->3 sum=6
 * 例子2:
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
*/
public class MaxPathSumBinaryTree {
    // 从树的最左侧开始找叶子结点，作为起点，一直遍历到其右侧的一个叶子结点结束，作为一条路径
    // 直接在root数组里面找就行，也不用构建为二叉树的TreeNode

    public static int MaxPathSumTraverse(Integer [] tree){
        List<Integer> leafIdxList = new ArrayList<>();
        int maxSum = Integer.MIN_VALUE;
        if (tree == null){
            return 0 ;
        }
        for(int idx = 0; idx < tree.length; idx ++){
            if (isLeaf(tree, idx)){
                leafIdxList.add(idx);
            }
        }
        for (int idx = 0; idx < leafIdxList.size(); idx ++){
            List<Integer> visitedEndList = new LinkedList<>();
            List<Integer> endList = leafIdxList.subList(idx, leafIdxList.size());
            int start = leafIdxList.get(idx);
            int current = start;
            boolean [] visited = new boolean[tree.length];
            int sum = 0;
            while (!visitedEndList.equals(endList)){
                visited[current] = true;
                sum += tree[current];

                int left = current * 2 + 1;
                int right = current * 2 + 2;  
                if (left < tree.length && tree[left] != null 
                && !visited[left]){ // goto left
                    current = left;
                    continue;
                }else if (right < tree.length && tree[right] != null 
                && !visited[right]){ // goto right
                    current = right;
                    continue;
                }

                if ( endList.contains(current) && !visitedEndList.contains(current)){
                //found one end, reinitialize visited array and mark visited end
                    if (maxSum < sum)
                        maxSum = sum;
                    visitedEndList.add(current);
                    visited = new boolean[tree.length];
                    for (int endidx : visitedEndList){
                        visited[endidx] = true;
                    }
                    sum = 0;
                    current = start;
                    continue;
                }
        
                int parent = (current - (2-current%2))/2;
                if(parent >= 0 && parent < tree.length 
                && tree[parent] != null && !visited[parent]) { // go back to parent
                    current = parent;
                    continue;
                }
            }
        }

        return maxSum;
    }

    private static boolean isLeaf(Integer [] tree , int curr){
        if (tree[curr] == null)
            return false;
        int left = 2 * curr + 1;
        int right = 2 * curr + 2;
        if (left < tree.length && tree[left] != null){
            return false;
        } 
        if (right < tree.length && tree[right] != null){
            return false;
        }
        return true;
    }
}
