import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    /**
     * 简单回溯法
     */
    public List<String> binaryTreePaths(TreeNode root) {

        // 回溯哦，深度优先搜索 -> 最优解
        return extracted(root);

        // 双队列，广度优先搜索
        // return extracted2(root);

    }

    /**
     * Your runtime beats 53.66 % of java submissions
     * Your memory usage beats 36.08 % of java submissions (41.5 MB)
     * 
     * @param root
     * @return
     */
    private List<String> extracted2(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        if (root == null) {
            return paths;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<String> pathQueue = new LinkedList<String>();

        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();

            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
                }

                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
                }
            }
        }
        return paths;
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 49.59 % of java submissions (41.2 MB)
     * 
     * @param root
     * @return
     */
    private List<String> extracted(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res, new StringBuilder());
        return res;
    }

    private void dfs(TreeNode node, List<String> res, StringBuilder temp) {
        if (node != null) {
            StringBuilder path = new StringBuilder(temp);
            path.append(node.val);
            if (node.left == null && node.right == null) {
                res.add(path.toString());
            } else {
                path.append("->");
                dfs(node.left, res, path);
                dfs(node.right, res, path);
            }
        }
    }
}
// @lc code=end
