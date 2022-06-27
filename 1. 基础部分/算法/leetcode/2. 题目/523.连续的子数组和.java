import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=523 lang=java
 *
 * [523] 连续的子数组和
 */

// @lc code=start
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // 哈希 记录余数的坐标
        // return extracted(nums, k);

        // 1
        return test(nums, k);
    }

    private boolean test(int[] nums, int k) {
        int len = nums.length;
        if (len < 2)
            return false;

        Map<Integer, Integer> map = new HashMap<>();
        int remainder = 0;
        // 初始化Map，假设能够整除k的数字从0开始
        map.put(0, -1);
        for (int i = 0; i < len; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int preIdx = map.get(remainder);
                if (i - preIdx >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }

    /**
     * Your runtime beats 14.71 % of java submissions
     * Your memory usage beats 23.13 % of java submissions (56.4 MB)
     * 
     * @param nums
     * @param k
     * @return
     */
    private boolean extracted(int[] nums, int k) {
        int m = nums.length;
        if (m < 2)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            // 如果包含响应的余数，说明这中间的字符可以被K整除
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                // 哈希表记录余数的下标
                map.put(remainder, i);
            }
        }
        return false;
    }
}
// @lc code=end
