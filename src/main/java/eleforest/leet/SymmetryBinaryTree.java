package eleforest.leet;

import java.util.Arrays;

import static java.lang.Math.max;

public class SymmetryBinaryTree {
    /*
    weights：下标位置保存对应编号节点的权重，一棵树完整的权重
    preOrd/inOrd: 以节点编号存的前序和中序遍历序列
     */
    public static TreeNode constructTree(int [] preOrd, int [] inOrd, int [] weights){
        if ( preOrd == null || inOrd == null || weights == null){
            return null;
        }
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
