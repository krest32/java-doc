import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=606 lang=java
 *
 * [606] 根据二叉树创建字符串
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
    public String tree2str(TreeNode root) {
        // 递归
        // return extracted(root);

        // 迭代
        return extracted2(root);
    }

    /**
     * Your runtime beats 63.23 % of java submissions
     * Your memory usage beats 19.26 % of java submissions (41.8 MB)
     * 
     * @param root
     * @return
     */
    private String extracted2(TreeNode root) {
        if (root == null)
            return "";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<TreeNode> visited = new HashSet<>();
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (visited.contains(root)) {
                stack.pop();
                s.append(")");
            } else {
                visited.add(root);
                s.append("(" + root.val);
                if (root.left == null && root.right != null)
                    s.append("()");
                if (root.right != null)
                    stack.push(root.right);
                if (root.left != null)
                    stack.push(root.left);
            }
        }
        return s.substring(1, s.length() - 1);
    }

    private String extracted(TreeNode root) {
        if (root == null)
            return "";
        if (root.left == null && root.right == null)
            return root.val + "";
        if (root.right == null)
            return root.val + "(" + tree2str(root.left) + ")";
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }
}
// @lc code=end
