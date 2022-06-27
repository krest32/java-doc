import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归
        // return extracted(root, p, q);

        // 一次遍历
        return extracted2(root, p, q);
    }

    /**
     * 一次遍历
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 44.07 % of java submissions (42 MB)
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    private TreeNode extracted2(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    /**
     * 递归
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    private TreeNode extracted(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果left为空，说明这两个节点在cur结点的右子树上，
        // 我们只需要返回右子树查找的结果即可
        if (left == null)
            return right;
        // 同上
        if (right == null)
            return left;
        // 如果left和right都不为空，说明这两个节点一个在cur的左子
        // 树上一个在cur的右子树上，
        // 我们只需要返回cur结点即可。
        return root;
    }
}
// @lc code=end
