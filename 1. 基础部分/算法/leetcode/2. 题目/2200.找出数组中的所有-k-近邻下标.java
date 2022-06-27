import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2200 lang=java
 *
 * [2200] 找出数组中的所有 K 近邻下标
 */

// @lc code=start
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new LinkedList<>();
        int length = nums.length;
        int slow = 0;
        for (int fast = 0; fast < length; fast++) {
            if (nums[fast] == key) {
                slow = Math.max(slow, fast - k); // 区间开始
                int end = Math.min(fast + k, length - 1); // 区间结束
                while (slow <= end) {
                    res.add(slow++);
                }
            }
        }
        return res;
    }
}
// @lc code=end
