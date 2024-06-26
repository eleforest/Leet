package eleforest.leet;

public class TreeNode{
    public TreeNode left;
    public TreeNode right;
    public int val;
    public TreeNode(int value){
        val = value;
    }
    
    public static void genCompleteTree(Integer [] treeSeq, int idx, TreeNode root){// 完全二叉树的序列
        // treeSeq is an Integer array that contain a sequence that describe a complete binary tree
        int lIdx = 2 * idx + 1;
        int rIdx = lIdx + 1;
        if (lIdx < treeSeq.length && treeSeq[lIdx] != null){
            root.left = new TreeNode(treeSeq[lIdx]);
            genCompleteTree(treeSeq, lIdx, root.left);
        }
        if (rIdx < treeSeq.length && treeSeq[rIdx] != null){
            root.right = new TreeNode(treeSeq[rIdx]);
            genCompleteTree(treeSeq, rIdx, root.right);
        }
        return;
    }
}
