import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=594 lang=java
 *
 * [594] 最长和谐子序列
 */

// @lc code=start
class Solution {
    public int findLHS(int[] nums) {
        // 滑动窗口+贪心-> 最优解
        // return extracted(nums);

        // 哈希
        // return extracted2(nums);

        // 1 哈希
        return test1(nums);
    }

    private int test1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.containsKey(entry.getKey() + 1)) {
                res = Math.max(res, map.get(entry.getKey() + 1) + entry.getValue());
            }
        }
        return res;
    }

    /**
     * Your runtime beats 36.51 % of java submissions
     * Your memory usage beats 9.47 % of java submissions (43.1 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted2(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int res = 0;
        // 记录每个数字出现的频率
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        // 计算当前数字与下一个数字出现的个数
        for (int key : cnt.keySet()) {
            if (cnt.containsKey(key + 1)) {
                res = Math.max(res, cnt.get(key) + cnt.get(key + 1));
            }
        }
        return res;
    }

    /**
     * Your runtime beats 97.23 % of java submissions
     * Your memory usage beats 30.04 % of java submissions (42.1 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        Arrays.sort(nums);
        int begin = 0;
        int res = 0;
        for (int end = 0; end < nums.length; end++) {
            while (nums[end] - nums[begin] > 1) {
                begin++;
            }
            if (nums[end] - nums[begin] == 1) {
                res = Math.max(res, end - begin + 1);
            }
        }
        return res;
    }
}
// @lc code=end
