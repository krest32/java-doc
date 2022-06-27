import java.util.Deque;
import java.util.LinkedList;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }

        // 从后序中找到树的根节点
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            int postorderVal = postorder[i];
            TreeNode node = deque.peek();
            if(node.val != inorder[inorderIndex]){
                node.right = new TreeNode(postorderVal);
                deque.push(node.right);
            }else{
                while(!deque.isEmpty() && deque.peek().val == inorder[inorderIndex]){
                    node = deque.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                deque.push(node.left);
            }
        }
        return root;
    }
}
// @lc code=end
