import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 */

// @lc code=start
class Solution {
    // hash 进行去重
    public boolean containsDuplicate(int[] nums) {
        // 解法一 哈希Set -> 最优
        return extracted(nums);

        // 解法二 排序-->效率最低
        // return extracted2(nums);

        // 工具类去重后比较长度
        // return IntStream.of(nums).distinct().count() != nums.length;
    }

    /**
     * 排序
     * 
     * Your runtime beats 9.8 % of java submissions
     * Your memory usage beats 5.01 % of java submissions (55.4 MB)
     * 
     * @param nums
     * @return
     */
    private boolean extracted2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 使用哈希
     * 
     * Your runtime beats 89.87 % of java submissions
     * Your memory usage beats 83.36 % of java submissions (49.4 MB)
     * 
     * @param nums
     * @return
     */
    private boolean extracted(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
