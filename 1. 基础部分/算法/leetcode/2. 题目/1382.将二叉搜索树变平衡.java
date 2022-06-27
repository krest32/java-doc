import java.util.ArrayList;
import java.util.List;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=1382 lang=java
 *
 * [1382] 将二叉搜索树变平衡
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
    List<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        getInorder(root);
        return build(0, list.size() - 1);
    }

    private TreeNode build(int left, int right) {
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        if (left <= mid - 1)
            root.left = build(left, mid - 1);
        if (right >= mid + 1)
            root.right = build(mid + 1, right);
        return root;
    }

    // 二叉树的中序遍历
    private void getInorder(TreeNode root) {
        if (root.left != null)
            getInorder(root.left);
        list.add(root.val);
        if (root.right != null)
            getInorder(root.right);
    }
}
// @lc code=end
