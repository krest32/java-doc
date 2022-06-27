import java.util.LinkedList;
import java.util.Queue;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=958 lang=java
 *
 * [958] 二叉树的完全性检验
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
    int n = 0, p = 0;

    public boolean isCompleteTree(TreeNode root) {
        if (!dfs(root, 1))
            return false;
        return n == p;
    }

    // k是当前节点编号
    public boolean dfs(TreeNode root, int k) {
        if (root == null)
            return true; // 递归到了叶子节点
        if (k > 100)
            return false;
        n++;
        // 记录节点数和最大节点编号值
        p = Math.max(p, k);
        // 递归左右子树
        return dfs(root.left, 2 * k) && dfs(root.right, 2 * k + 1); 
    }
}
// @lc code=end
