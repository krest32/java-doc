/*
 * @lc app=leetcode.cn id=701 lang=java
 *
 * [701] 二叉搜索树中的插入操作
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }

        TreeNode pos = root;
        while(pos != null){
            if(val < pos.val){
                if(pos.left == null){
                    pos.left = new TreeNode(val);
                    break;
                }else{
                    pos = pos.left;
                }
            }else{
                if(pos.right == null){
                    pos.right = new TreeNode(val);
                    break;
                }else{
                    pos = pos.right;
                }
            }
        }
        return root;
    }
}
// @lc code=end

