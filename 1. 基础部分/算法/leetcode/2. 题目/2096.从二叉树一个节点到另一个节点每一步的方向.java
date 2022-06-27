import java.util.HashMap;
import java.util.Map;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=2096 lang=java
 *
 * [2096] 从二叉树一个节点到另一个节点每一步的方向
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {


    Map<Integer, TreeNode> parent = new HashMap<>();
    StringBuilder ret = new StringBuilder();

    public String getDirections(TreeNode root, int startValue, int destValue) {
        // 回溯
        return extracted(root, startValue, destValue);
    }

    /**
     * Your runtime beats 19.44 % of java submissions
     * Your memory usage beats 19.17 % of java submissions (84.3 MB)
     * 
     * @param root
     * @param startValue
     * @param destValue
     * @return
     */
    private String extracted(TreeNode root, int startValue, int destValue) {
        findParent(root);
        TreeNode node = getTreeNode(startValue, root);
        dfs(startValue, destValue, new StringBuilder(), node);
        return ret.toString();
    }

    TreeNode getTreeNode(int val, TreeNode root) {
        TreeNode node = parent.get(val);
        if (node == null) {
            return root;
        }
        if (node.left != null && node.left.val == val) {
            return node.left;
        }
        if (node.right != null && node.right.val == val) {
            return node.right;
        }
        return null;
    }

    private void dfs(int from, int dest,
            StringBuilder res,
            TreeNode node) {
        if (node.val == dest) {
            if (ret.length() == 0) {
                ret = new StringBuilder(res);
            } else {
                if (res.length() < ret.length()) {
                    ret = new StringBuilder(res);
                }
            }
            return;
        }
        // 需要有三个遍历的方向，但是不能遍历自己来时的方向
        if (node.left != null && node.left.val != from) {
            res.append("L");
            dfs(node.val, dest, res, node.left);
            res.deleteCharAt(res.length() - 1);

        }
        if (node.right != null && node.right.val != from) {
            res.append("R");
            dfs(node.val, dest, res, node.right);
            res.deleteCharAt(res.length() - 1);
        }
        if (parent.get(node.val) != null && parent.get(node.val).val != from) {
            res.append("U");
            dfs(node.val, dest, res, parent.get(node.val));
            res.deleteCharAt(res.length() - 1);
        }
    }
    private void findParent(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            findParent(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            findParent(root.right);
        }
    }
}
// @lc code=end
