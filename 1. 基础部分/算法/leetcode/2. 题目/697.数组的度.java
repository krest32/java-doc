import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=697 lang=java
 *
 * [697] 数组的度
 */

// @lc code=start
class Solution {
    public int findShortestSubArray(int[] nums) {
        // 哈希表
        return extracted(nums);
    }

    /**
     * Your runtime beats 88.57 % of java submissions
     * Your memory usage beats 29.77 % of java submissions (45.6 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int n = nums.length;
        /**
         *  Map 记录的数组三个元素分别代表:
         *  这个数出现的次数、
         *  这个数在原数组中第一次出现的位置
         *  和这个数在原数组中最后一次出现的位置
         */
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[] { 1, i, i });
            }
        }
        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum < arr[0]) {
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]) {
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }
}
// @lc code=end
