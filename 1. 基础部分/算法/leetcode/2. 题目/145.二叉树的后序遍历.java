import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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

    // 递归遍历
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        // 递归
        return extracted(root);

        // 迭代
        // return extracted2(root);
    }

    /**
     * 迭代算法
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 43.79 % of java submissions (39.4 MB)
     * 
     * @param root
     * @return
     */
    private List<Integer> extracted2(TreeNode root) {
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }
        return res;
    }

    /**
     * 递归算法
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 43.1 % of java submissions (39.4 MB)
     * 
     * @param root
     * @return
     */
    private List<Integer> extracted(TreeNode root) {
        getNode(root);
        return res;
    }

    private void getNode(TreeNode root) {
        if (root == null) {
            return;
        }
        getNode(root.left);
        getNode(root.right);
        res.add(root.val);
    }
}
// @lc code=end
