import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1726 lang=java
 *
 * [1726] 同积元组
 */

// @lc code=start
class Solution {
    public int tupleSameProduct(int[] nums) {
        // 模拟
        return extracted(nums);
    }

    /**
     * Your runtime beats 65.65 % of java submissions
     * Your memory usage beats 77.1 % of java submissions (61.7 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int targetNum = nums[i] * nums[j];
                map.put(targetNum, map.getOrDefault(targetNum, 0) + 1);
            }
        }

        int ret = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value >= 2) {
                ret += 2 * 2 * getSum(value);
            }
        }
        return ret;
    }

    private int getSum(int value) {
        return value * (value - 1);
    }
}
// @lc code=end
