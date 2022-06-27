import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return ret;
        }
        dfs(root, targetSum);
        return ret;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        } else {
            path.add(root.val);
            targetSum = targetSum - root.val;
            if (root.left == null && root.right == null && targetSum == 0) {
                ret.add(new LinkedList<Integer>(path));
            }
            dfs(root.left, targetSum);
            dfs(root.right, targetSum);
            path.remove(path.size() - 1);

        }
    }
}
// @lc code=end
