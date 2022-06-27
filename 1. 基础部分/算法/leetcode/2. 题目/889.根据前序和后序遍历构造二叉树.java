import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=889 lang=java
 *
 * [889] 根据前序和后序遍历构造二叉树
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
    int[] pre, post;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.pre = preorder;
        this.post = postorder;
        return make(0, 0, pre.length);
    }

    private TreeNode make(int idx0, int idx1, int len) {
        if (len == 0)
            return null;
        // 先序遍历找到头结点
        TreeNode root = new TreeNode(pre[idx0]);
        if (len == 1)
            return root;
        int l = 1;
        // 从后序遍历中确认先序遍历的子节点个数，
        // 从而确认先序遍历中右子树的数组坐标
        for (; l < len; l++) {
            if (post[idx1 + l - 1] == pre[idx0 + 1])
                break;
        }
        System.out.print(l + " ");
        // l 与 len-l-1 表示剩余需要构建的数组的值的个数
        root.left = make(idx0 + 1, idx1, l);
        root.right = make(idx0 + l + 1, idx1 + l, len - l - 1);
        return root;
    }
}
// @lc code=end
