import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1685 lang=java
 *
 * [1685] 有序数组中差绝对值之和
 */

// @lc code=start
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        // 暴力 -- > 超时(即便使用了记忆)
        // return extracted(nums);

        // 前綴和
        return extracted2(nums);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 5.26 % of java submissions (58.8 MB)
     * 
     * @param nums
     * @return
     */
    private int[] extracted2(int[] nums) {
        int length = nums.length;
        int result[] = new int[length];

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }

        int su = 0;
        for (int i = 0; i < length; i++) {
            result[i] = sum - nums[i] * length + (i * nums[i] - su) * 2;
            su += nums[i];
        }
        return result;
    }

    private int[] extracted(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = getNum(nums, i, map);
        }
        return res;
    }

    private int getNum(int[] nums, int k, Map<Integer, Integer> map) {
        int sum = 0;
        int cur = nums[k];
        if (map.getOrDefault(cur, 0) != 0) {
            return map.get(cur);
        }
        for (int i = 0; i < nums.length; i++) {
            sum += Math.abs(nums[i] - cur);
        }
        map.put(cur, sum);
        return sum;
    }
}
// @lc code=end
