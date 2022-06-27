import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import entrty.Node;

/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N 叉树的最大深度
 */

// @lc code=start
// Definition for a Node.

class Solution {

    public int maxDepth(Node root) {
        // 深度优先
        // return extracted(root);

        // 广度优先
        return extracted2(root);
    }

    private int extracted2(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node node = queue.poll();
                List<Node> children = node.children;
                for (Node child : children) {
                    queue.offer(child);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

    private int extracted(Node root) {
        if (root == null) {
            return 0;
        }

        int maxDepth = 0;
        List<Node> childs = root.children;
        for (Node child : childs) {
            int childDepth = maxDepth(child);
            maxDepth = Math.max(maxDepth, childDepth);
        }
        return maxDepth + 1;
    }
}
// @lc code=end
