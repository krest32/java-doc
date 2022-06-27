import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 */

// @lc code=start
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 哈希
        // return extracted(nums, k);

        // 滑动窗口 -> 最优
        return extracted2(nums, k);
    }

    /**
     * 滑动窗口
     * 注意边界问题 i-k-1, 与 i>k
     *
     * Your runtime beats 96.97 % of java submissions
     * Your memory usage beats 43.85 % of java submissions (50 MB)
     * 
     * @param nums
     * @param k
     * @return
     */
    private boolean extracted2(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 哈希
     * 
     * Your runtime beats 85.04 % of java submissions
     * Your memory usage beats 49.39 % of java submissions (49.2 MB)
     * 
     * @param nums
     * @param k
     * @return
     */
    private boolean extracted(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            // 利用 map 集合查找符合要求的元素
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }
}
// @lc code=end
