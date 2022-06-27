import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=747 lang=java
 *
 * [747] 至少是其他数字两倍的最大数
 */

// @lc code=start

class Solution {
    public int dominantIndex(int[] nums) {
        // 线性求取最大值和次大值 --> 最优解
        // return extracted(nums);

        // 哈希
        // return extracted2(nums);

    }

    /**
     * Your runtime beats 7.35 % of java submissions
     * Your memory usage beats 5 % of java submissions (39.2 MB)
     */
    private int extracted2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        if (nums.length == 1)
            return nums.length - 1;
        return nums[nums.length - 2] * 2 <= nums[nums.length - 1]
                ? map.get(nums[nums.length - 1])
                : -1;
    }

    private int extracted(int[] nums) {
        int m1 = -1, m2 = -1;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > m1) {
                m2 = m1;
                // m1 是最大值
                m1 = nums[i];
                // index 是最大值的下标
                index = i;
            } else if (nums[i] > m2) {
                // 找到次大值
                m2 = nums[i];
            }
        }
        return m1 >= m2 * 2 ? index : -1;
    }
}
// @lc code=end
