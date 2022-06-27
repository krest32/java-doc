import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
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
    public int widthOfBinaryTree(TreeNode root) {
        // 广度遍历 + 双端队列
        // return extracted(root);

        // 给树的每个节点进行编号，然后比较最左边和最右边的数字大小即可

        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int maxWidth = 0;
        while (!deque.isEmpty()) {
            int count = deque.size();
            maxWidth = Math.max(maxWidth, deque.peekLast().val - deque.peekFirst().val + 1);
            for (int i = 0; i < count; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    node.left.val = node.val * 2 + 1;
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 2;
                    deque.offer(node.right);
                }
            }
        }
        return maxWidth;

    }

    private int extracted(TreeNode root) {
        if (root == null)
            return 0;
        // 双端队列
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int width = queue.size();
            maxWidth = Math.max(maxWidth, queue.peekLast().val - queue.peekFirst().val + 1);
            while (width > 0) {
                width--;
                TreeNode node = queue.poll();
                // 更改值，然后记录当前的放入的数值
                if (node.left != null) {
                    node.left.val = node.val * 2 + 1;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 2;
                    queue.offer(node.right);
                }
            }
        }
        return maxWidth;
    }
}
// @lc code=end
