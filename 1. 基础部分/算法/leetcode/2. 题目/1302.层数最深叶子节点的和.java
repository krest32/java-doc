import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=1302 lang=java
 *
 * [1302] 层数最深叶子节点的和
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
    private int total = 0;
    private int Maxdeep = -1;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return total;
    }
    private void dfs(TreeNode node, int deep){
        // 如果当前节点为空，直接返回，否则深度加1；
        if(node == null)
            return;
        deep++;
        
        //如果当前深度大于最大深度
        if(deep > Maxdeep){
            //更新最大深度
            Maxdeep = deep;
            // 同时设置total的值，total等于当前输的深度的和，每次都会更新最大深度，同时更新最大深度的第一个节点的值
             total = node.val;
        }
        // 当同样深度还有其他节点时，就将total的值进行累加
        else if(deep == Maxdeep){
            total =total+node.val;
        }

        dfs(node.left, deep);
        dfs(node.right, deep);

    }
}
// @lc code=end

