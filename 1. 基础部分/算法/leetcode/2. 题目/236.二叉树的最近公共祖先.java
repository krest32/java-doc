import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
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

    private TreeNode cur = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return cur;
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 48.14 % of java submissions (42.6 MB)
     * 判斷根节点和子节点之间的关系
     * 定义函数表示x节点的子树中是否包含 p节点或 q节点，如果包含为 true，否则为 false
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;

        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);

        if ((lson && rson) || (root.val == p.val || root.val == q.val && (lson || rson))) {
            cur = root;
        }

        return lson || rson || root.val == q.val || root.val == p.val;
    }

}
// @lc code=end
