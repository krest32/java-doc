/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    private int maxGain(TreeNode node) {
        if(node == null){
            return 0;
        }

        int leftGin = Math.max(maxGain(node.left), 0);
        int rigthGin = Math.max(maxGain(node.right), 0);

        int priceNewPath = node.val + leftGin +rigthGin;

        maxSum = Math.max(maxSum, priceNewPath);

        return node.val+Math.max(leftGin, rigthGin);
    }
    
}
// @lc code=end

