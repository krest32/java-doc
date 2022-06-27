import java.util.LinkedList;
import java.util.Queue;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=938 lang=java
 *
 * [938] 二叉搜索树的范围和
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        // 广度优先搜索
        // return extracted(root, low, high);

        // 深度优先索
        return extracted2(root, low, high);

    }

    private int extracted2(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val > high) {
            return extracted2(root.left, low, high);
        }
        if (root.val < low) {
            return extracted2(root.right, low, high);
        }
        return root.val + extracted2(root.left, low, high)
                + extracted2(root.right, low, high);
    }

    private int extracted(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int sum = 0;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                continue;
            }
            if (cur.val >= low && cur.val <= high) {
                sum = sum + cur.val;
            }
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return sum;
    }
}
// @lc code=end
