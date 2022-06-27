import java.util.LinkedList;
import java.util.Queue;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    public int maxDepth(TreeNode root) {
        // 递归
        // return maxLen(root);

        // 迭代
        return extracted(root);
    }

    /**
     * 迭代
     * 
     * @param root
     * @return
     */
    private int extracted(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

    private int maxLen(TreeNode root) {
        // 判空
        if (root == null)
            return 0;

        // 获取左右子树各自最大深度
        int left = maxLen(root.left);
        int right = maxLen(root.right);

        // 获取当前子树的深度+1
        return Math.max(left, right) + 1;
    }
}
// @lc code=end
