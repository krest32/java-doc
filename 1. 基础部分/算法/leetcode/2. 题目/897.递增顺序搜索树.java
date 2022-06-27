import java.util.ArrayList;
import java.util.List;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=897 lang=java
 *
 * [897] 递增顺序搜索树
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

    private TreeNode resNode;

    public TreeNode increasingBST(TreeNode root) {
        // 模拟
        return extracted(root);

        // 在遍历的过程中指定节点的方向
        // return extracted2(root);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 27.53 % of java submissions (38.9 MB)
     * 
     * @param root
     * @return
     */
    private TreeNode extracted2(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        inorderCreate(root);
        return dummyNode.right;
    }

    private void inorderCreate(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderCreate(node.left);

        // 在中序遍历的过程中修改节点指向
        resNode.right = node;
        node.left = null;
        resNode = node;

        inorderCreate(node.right);

    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 25.64 % of java submissions (39 MB)
     * 
     * @param root
     * @return
     */
    private TreeNode extracted(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // 中序遍历
        inorder(root, res);
        // 哑元节点
        TreeNode dumNode = new TreeNode(-1);
        // 构建链式节点
        TreeNode cur = dumNode;
        for (int val : res) {
            cur.right = new TreeNode(val);
            cur = cur.right;
        }
        return dumNode.right;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
// @lc code=end
