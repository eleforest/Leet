package eleforest.leet;


import java.util.ArrayList;
import java.util.List;

public class LevelTraverseBinaryTree {

    public static List<TreeNode> levelTraverse(TreeNode root){
        List<TreeNode> levelResult = new ArrayList<>();
        if (root == null) {
            return levelResult;
        }
        TreeNode curr ;
        levelResult.add(root);
        int idx = 0;
        while (idx < levelResult.size()) {
            curr = levelResult.get(idx);
            if (curr.left != null) {
                levelResult.add(curr.left);
            }
            if (curr.right != null) {
                levelResult.add(curr.right);
            }
            idx ++;
        }
        return levelResult;
    }
}
