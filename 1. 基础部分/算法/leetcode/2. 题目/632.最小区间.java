import java.util.List;

/*
 * @lc app=leetcode.cn id=632 lang=java
 *
 * [632] 最小区间
 */

// @lc code=start
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // 获取最大的区间，然后进行缩小
        int start = 0;
        int end = 0;
        for (List<Integer> list : nums) {
            start = Math.min(start, list.get(0));
            end = Math.max(end, list.get(list.size() - 1));
        }
        
    }
}
// @lc code=end
