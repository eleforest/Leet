package eleforest.leet;
/*
 * 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点
 * 如：
 *      1
 *    2   3
 * 返回：12+13=25
 * 
 */

public class SumFromRoot2Leaf {
    public static void genTree(int [] treeSeq, int idx, TreeNode root){// 完全二叉树的序列
        int lIdx = 2 * idx + 1;
        int rIdx = lIdx + 1;
        if (lIdx < treeSeq.length){
            root.left = new TreeNode(treeSeq[lIdx]);
            genTree(treeSeq, lIdx, root.left);
        }
        if (rIdx < treeSeq.length){
            root.right = new TreeNode(treeSeq[rIdx]);
            genTree(treeSeq, rIdx, root.right);
        }
        return;
    }

    public static int sumTraverse(TreeNode root, int prev){
        if (root == null || prev < 0 || prev > 9)// illegal
            return -1;
        int curr = prev * 10 + root.val;
        int leftSum = 0, rightSum = 0;
        if (root.left == null && root.right == null){
            return curr;
        }
        if (root.left != null){
            leftSum = sumTraverse(root.left, curr);
        }
        if (root.right != null){
            rightSum = sumTraverse(root.right, curr);
        }
        return leftSum + rightSum;
    }

}
