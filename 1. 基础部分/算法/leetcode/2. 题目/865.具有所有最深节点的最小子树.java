import java.util.HashMap;
import java.util.Map;

import javax.swing.event.AncestorEvent;

/*
 * @lc app=leetcode.cn id=865 lang=java
 *
 * [865] 具有所有最深节点的最小子树
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
    Map<TreeNode, Integer> depths;
    int maxDepth;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depths = new HashMap<>();
        depths.put(null, -1);
        dfs(root, null);
        maxDepth = -1;
        for (Integer depth : depths.values()) {
            maxDepth = Math.max(maxDepth, depth);
        }

        return answer(root);
    }

    private void dfs(TreeNode node, Object parent) {
        if (node != null) {
            depths.put(node, depths.get(parent) + 1);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    private TreeNode answer(TreeNode node) {
        if (node == null || depths.get(node) == maxDepth) {
            return node;
        }
        TreeNode L = answer(node.left), R = answer(node.right);
        if (L != null && R != null) {
            return node;
        }
        if (L != null) {
            return L;
        }
        if (R != null) {
            return R;
        }
        return null;
    }

}
// @lc code=end
