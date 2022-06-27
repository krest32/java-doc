import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import entrty.Node;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        // 队列实现层次遍历
        return extracted(root);
    }

    /**
     * Your runtime beats 75.04 % of java submissions
     * Your memory usage beats 17.38 % of java submissions (42.5 MB)
     * 
     * @param root
     * @return
     */
    private List<List<Integer>> extracted(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                List<Node> childs = node.children;
                for (int j = 0; j < childs.size(); j++) {
                    if (childs.get(j) != null) {
                        queue.offer(childs.get(j));
                    }
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
// @lc code=end
