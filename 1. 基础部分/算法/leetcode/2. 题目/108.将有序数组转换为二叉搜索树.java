import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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
    public TreeNode sortedArrayToBST(int[] nums) {
        // 递归
        return buildTree(nums, 0, nums.length - 1);
    }

    // 利用中序遍历的方式去构建树
    private TreeNode buildTree(int[] nums, int start, int end) {
        // 递归停止条件
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode();
        int mid = start + (end - start) / 2;

        // 分别构建左右子树
        TreeNode left = buildTree(nums, start, mid - 1);
        TreeNode right = buildTree(nums, mid + 1, end);
        root.val = nums[mid];
        root.left = left;
        root.right = right;
        return root;
    }
}
// @lc code=end
