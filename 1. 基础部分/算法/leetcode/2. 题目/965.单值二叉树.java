import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=965 lang=java
 *
 * [965] 单值二叉树
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
    int val;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        val = root.val;

        return dfs(root.left) && dfs(root.right);
    }

    private boolean dfs(TreeNode node) {
        if (node == null)
            return true;

        return node.val == val
                && dfs(node.left)
                && dfs(node.right);

    }
}
// @lc code=end
