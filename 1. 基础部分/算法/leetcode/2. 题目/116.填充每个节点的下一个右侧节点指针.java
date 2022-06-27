import java.util.LinkedList;
import java.util.Queue;

import entrty.Node;
import entrty.TreeNode;

/**
 * @lc app=leetcode.cn id=116 lang=java
 *
 *     [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public Node left;
 * public Node right;
 * public Node next;
 * 
 * public Node() {}
 * 
 * public Node(int _val) {
 * val = _val;
 * }
 * 
 * public Node(int _val, Node _left, Node _right, Node _next) {
 * val = _val;
 * left = _left;
 * right = _right;
 * next = _next;
 * }
 * };
 */

class Solution {
    public Node connect(Node root) {
        // 层次遍历
        // return extracted(root);

        // 1
        return test(root);
    }

    private Node extracted2(Node root) {
        if (root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                if (i == size - 1) {
                    temp.next = null;
                } else {
                    temp.next = queue.peek();
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return root;
    }

    private Node extracted(Node root) {
        if (root == null) {
            return root;
        }
        // 广度优先遍历二叉树
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                // 遍历过程中为next添加指针坐标
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        // 返回根节点
        return root;
    }
}
// @lc code=end
