import java.util.ArrayList;
import java.util.List;


/*
 * @lc app=leetcode.cn id=971 lang=java
 *
 * [971] 翻转二叉树以匹配先序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> list = new ArrayList<>();
        if(root.val != voyage[0]) {
            list.add(-1);
            return list;
        }
        //这里new int[]{0}，用数组不要用变量 因为基本类型传参是副本，引用是传递地址，当然你也可以用静态的基本类型，我不想所以用数组。
        if(!dfs(null,root,voyage,new int[]{0},list)){
            list.clear();
            list.add(-1);
        }
        return list;
    }
    public boolean dfs(TreeNode root, TreeNode node, int[] voyage, int[] i, List<Integer> list){
        if(voyage[i[0]] != node.val){
            if(root.right != null && root.right.val == voyage[i[0]]){
                list.add(root.val);
                root.left = root.right;
                root.right = node;
                node = root.left;
            }else return false;
        }
        if(node.left != null) {
            i[0]++;
            if(!dfs(node,node.left,voyage,i, list)) return false;
        }
        if(node.right != null) {
            i[0]++;
           if(!dfs(node,node.right,voyage,i, list)) return false; 
        }
        return true;
    }
}
// @lc code=end

