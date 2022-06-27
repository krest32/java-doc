import java.util.LinkedList;
import java.util.Queue;

import entrty.Node;

/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        // BFS
        return extracted(root);
    }

    private Node extracted(Node root) {
        if (root == null) {
            return null;
        }
        // 二叉树的层次遍历
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null;
            // 遍历每一个节点
            for (int i = 1; i <= n; ++i) {
                Node cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                // 当这一层大于1时，添加指针，
                if (i != 1) {
                    last.next = cur;
                }
                last = cur;
            }
        }
        return root;
    }
}
// @lc code=end
