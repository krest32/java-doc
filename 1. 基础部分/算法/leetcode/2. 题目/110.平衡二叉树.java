import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        /**
         * 1. 判断单钱树是否平衡
         * 2. 分辨判断左右子树是否平衡
         */
        return Math.abs(leftDepth - rightDepth) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    // 获取树的深度
    private int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        return Math.max(right, left) + 1;
    }
}
// @lc code=end
