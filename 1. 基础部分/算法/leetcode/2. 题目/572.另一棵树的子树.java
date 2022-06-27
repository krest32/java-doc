import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572]  另一棵树的子树
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
    public boolean isSubtree(TreeNode s, TreeNode t) {

        // 递归
        // return extracted(s, t);

        // 判断特殊情况
        if (t == null)
            return true;
        if (s == null)
            return false;

        return isSameTreeTest(s, t)
                || isSubtree(s.left, t)
                || isSubtree(s.right, t);

    }

    private boolean isSameTreeTest(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return s.val == t.val
                && isSameTreeTest(s.left, t.left)
                && isSameTreeTest(s.right, t.right);
    }

    private boolean extracted(TreeNode s, TreeNode t) {
        if (t == null)
            return true;
        if (s == null)
            return false;
        return isSubtree(s.left, t)
                || isSubtree(s.right, t)
                || isSameTree(s, t);
    }

    /**
     * 判断两棵树是否相同
     */
    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val != t.val)
            return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

}
// @lc code=end
