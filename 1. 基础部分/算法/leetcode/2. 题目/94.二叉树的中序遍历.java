import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import entrty.TreeNode;

/**
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {

        /**
         * 三种方法速度相差不多，但是迭代使用了Stack，
         * 所以空间会有一定的多余使用
         */
        // 方法一 递归法
        // return extracted(root);

        // 方法二 迭代法
        // return extracted2(root);

        // 方法三 Morris 中序遍历 了解即可
        return extracted3(root);
    }

    /**
     * Morris 中序遍历
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 40.16 % of java submissions (39.4 MB)
     * 
     * @param root
     * @return
     */
    private List<Integer> extracted3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * 迭代
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 20.99 % of java submissions (39.6 MB)
     * 
     * @param root
     * @return
     */
    private List<Integer> extracted2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     * 递归法
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 49.83 % of java submissions (39.2 MB)
     * 
     * @param root
     * @return
     */
    private List<Integer> extracted(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        reverse(res, root);
        return res;
    }

    private void reverse(List<Integer> res, TreeNode root) {
        if (root == null)
            return;
        reverse(res, root.left);
        res.add(root.val);
        reverse(res, root.right);
    }
}
// @lc code=end
