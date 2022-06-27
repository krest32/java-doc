import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=2154 lang=java
 *
 * [2154] 将找到的值乘以 2
 */

// @lc code=start
class Solution {
    public int findFinalValue(int[] nums, int original) {
        // 模拟
        return extracted(nums, original);

    }

    /**
     * 81/81 cases passed (3 ms)
     * Your runtime beats 41.74 % of java submissions
     * Your memory usage beats 5.31 % of java submissions (41.9 MB)
     * 
     * @param nums
     * @param original
     * @return
     */
    private int extracted(int[] nums, int original) {
        // 去重
        Set<Integer> uset = new HashSet<>();
        for (int x : nums) {
            uset.add(x);
        }

        int x = original;
        while (uset.contains(x) == true) {
            x <<= 1;
        }

        return x;
    }
}
// @lc code=end
