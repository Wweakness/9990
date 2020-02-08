//前序遍历

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class Solution {
    private List<Integer> list;

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        preOrder(root);
        return list;
    }
}
