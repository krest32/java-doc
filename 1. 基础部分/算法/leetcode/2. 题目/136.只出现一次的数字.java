import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        // 异或算法
        // return extracted(nums);

        // 哈希表
        return extracted2(nums);

    }

    /**
     * Your runtime beats 13.95 % of java submissions
     * Your memory usage beats 8.4 % of java submissions (41.7 MB)S
     * 
     * @param nums
     * @return
     */
    private int extracted2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1; // can't find it.
    }

    /**
     * 异或算法
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {

        // 相同值异或，等于0，如此可以去掉出现两次的数字
        // 不同值异或，等于原值，留下仅仅出现一次的数字
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            target = target ^ nums[i];
        }
        return target;
    }
}
// @lc code=end
