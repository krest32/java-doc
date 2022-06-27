import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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

    // 递归遍历二叉树
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        // 深度优先搜索
        // return extracted(root);

        // 广度优先搜说
        return extracted2(root);
    }

    /**
     * 迭代算法
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 39.56 % of java submissions (39.4 MB)
     * 
     * @param root
     * @return
     */
    private List<Integer> extracted2(TreeNode root) {
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    private List<Integer> extracted(TreeNode root) {
        getNode(root);
        return res;
    }

    private void getNode(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        getNode(root.left);
        getNode(root.right);
    }
}
// @lc code=end
