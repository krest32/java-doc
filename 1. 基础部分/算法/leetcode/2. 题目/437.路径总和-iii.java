/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
    public int pathSum(TreeNode root, int targetSum) {
        // 排除特殊情况
        if (root == null) {
            return 0;
        }
        // 计算从根开始的路径和数量
        int ret = rootSum(root, targetSum);
        
         // 计算从左子树开始的路径和数量
        ret += pathSum(root.left, targetSum);
         // 计算从右子树开始的路径和数量
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;
        // 排除特殊情况
        if (root == null) {
            return 0;
        }

        // 递归终止条件
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        // 分别计算左子树和右子树的路径和总数
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
}
// @lc code=end

