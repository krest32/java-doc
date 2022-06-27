import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=2190 lang=java
 *
 * [2190] 数组中紧跟 key 之后出现最频繁的数字
 */

// @lc code=start
class Solution {
    public int mostFrequent(int[] nums, int key) {
        // 哈希表
        // return extracted(nums, key);

        // 数组代替哈希表,性能上会有所提升
        return extracted2(nums, key);
    }

    /**
     * 101/101 cases passed (1 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 27.66 % of java submissions (41.5 MB)
     * 
     * @param nums
     * @param key
     * @return
     */
    private int extracted2(int[] nums, int key) {
        int[] counts = new int[1001];
        int result = 0;
        int maxSum = 0;

        for (int i = 1; i < nums.length; i++) {
            // 计算每次key出现时，target出现的次数
            if (nums[i - 1] == key) {
                counts[nums[i]]++;
                if (counts[nums[i]] > maxSum) {
                    result = nums[i];
                    maxSum = counts[nums[i]];
                }
            }
        }
        return result;
    }

    /**
     * 101/101 cases passed (3 ms)
     * Your runtime beats 40.19 % of java submissions
     * Your memory usage beats 17.12 % of java submissions (41.6 MB)
     * 
     * @param nums
     * @param key
     * @return
     */
    private int extracted(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        int curNum = nums[0];
        int maxTimes = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == key && i + 1 < len) {
                int nextNum = nums[i + 1];
                map.put(nextNum, map.getOrDefault(nextNum, 0) + 1);
                curNum = maxTimes < map.get(nextNum) ? nextNum : curNum;
                maxTimes = maxTimes < map.get(nextNum) ? map.get(nextNum) : maxTimes;
            }
        }
        return curNum;
    }
}
// @lc code=end
