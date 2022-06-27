/*
 * @lc app=leetcode.cn id=814 lang=java
 *
 * [814] 二叉树剪枝
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return dfs(root) ? root:null;
    }

    // 检测节点是否包含1？
    private boolean dfs(TreeNode node) {
        if(node == null) return false;
        boolean left = dfs(node.left);
        boolean right = dfs(node.right);
        if(!left) node.left = null;
        if(!right) node.right = null;
        return node.val == 1 || left || right;
    }
}
// @lc code=end

