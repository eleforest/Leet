package eleforest.leet;
/*
二叉树每个节点都有value，如果一棵二叉树的左右子树交换后，树结构和各个节点对应的value都相等，则称这棵树为对称二叉树
例如下面这棵二叉树是一棵对称二叉树
      1
    5   5
   2 3 3 2
而以下这两棵树就不是对称二叉树。
      1             1
    5   5         5   5
   3     2      3    3
现给定一棵二叉树的前序和中序序列，以及此树每个节点的value，请找到这棵树中权值最大的对称子树并输出其权值。注意，一个节点的树也是子树。
输入为：
4 //四个节点
1 2 4 4 //1到4号节点每个节点的权值
0 1 2 3 //前序遍历序列
2 1 3 0 //中序遍历序列

输出：10
    1
   2
  4 4
 其中以2号节点为根的子树为对称子树，其权重和为10
 */

import java.util.Arrays;

import static java.lang.Math.max;

public class SymmetryBinaryTree {
    private static Integer maxSumWeight = 0;
    /*
    weights：下标位置保存对应编号节点的权重，一棵树完整的权重
    preOrd/inOrd: 以节点编号存的前序和中序遍历序列
     */
    public static TreeNode constructTree(int [] preOrd, int [] inOrd, int [] weights){
        if (preOrd.length != inOrd.length || preOrd.length == 0){ // error
            return null;
        }
        TreeNode root = new TreeNode(weights[preOrd[0]]);
        if (preOrd.length == 1) {
            return root;
        }
        int rootIdx = -1;
        for(int idx = 0; idx < inOrd.length; idx ++){
            if (inOrd[idx] == preOrd[0]) {// look for root
                rootIdx = idx;
                break;
            }
        }
        if (rootIdx == -1){ // root not found in inOrd
            return null;
        }
        int [] leftInOrd = Arrays.copyOfRange(inOrd, 0, rootIdx );
        int [] rightInOrd = Arrays.copyOfRange(inOrd, rootIdx + 1, inOrd.length);
        int [] leftPreOrd = Arrays.copyOfRange(preOrd, 1, rootIdx + 1);
        int [] rightPreOrd = Arrays.copyOfRange(preOrd, rootIdx + 1, preOrd.length);
        root.left = constructTree(leftPreOrd, leftInOrd, weights);
        root.right = constructTree(rightPreOrd, rightInOrd, weights);
        return root;
    }

    public static boolean symmetric(TreeNode l, TreeNode r){
        if (l == null && r == null) {// 都为空，对称
            return true;
        }
        if (l == null || r == null) {// 任意一个为null，非对称
            return false;
        }
        return l.val == r.val && symmetric(l.left, r.right) && symmetric(l.right, r.left);
    }

    private static int maxSymmetricTreeWeight(TreeNode root){
        if(root == null)
            return 0;
        if (symmetric(root.left, root.right)){
            return calcWeight(root);
        } else {
            return max(maxSymmetricTreeWeight(root.left), maxSymmetricTreeWeight(root.right));
        }
    }
    private static int calcWeight(TreeNode root){
        if (root == null){
            return 0;
        }
        return root.val + calcWeight(root.left) + calcWeight(root.right);
    }

    public static int maxWeight(int [] preOrd, int []inOrd, int []weight){
        TreeNode root = constructTree(preOrd, inOrd, weight);
        return maxSymmetricTreeWeight(root);
    }

}
