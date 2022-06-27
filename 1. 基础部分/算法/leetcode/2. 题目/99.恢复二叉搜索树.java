import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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
    List<Integer> list = new ArrayList<>();

    public void recoverTree(TreeNode root) {
        // 遍历
        dfs(root);
        int first = 0;
        int second = 0;
        List<Integer> copy = new ArrayList<>(list);

        Collections.copy(list, copy);
        Collections.sort(copy);
        // 找到需要交换的节点
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != copy.get(i)) {
                second = first;
                first = list.get(i);
            }
        }

        changeValue(root, first, second);

    }

    /**
     * Your runtime beats 5.56 % of java submissions
     * Your memory usage beats 30.6 % of java submissions (41.4 MB)
     * 
     * @param root
     * @param first
     * @param second
     */
    private void changeValue(TreeNode root, int first, int second) {
        if (root == null) {
            return;
        }
        changeValue(root.left, first, second);
        if (root.val == first) {
            root.val = second;
        } else if (root.val == second) {
            root.val = first;
        }
        changeValue(root.right, first, second);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
// @lc code=end
