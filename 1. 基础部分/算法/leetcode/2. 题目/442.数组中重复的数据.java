import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        /**
         * 找到数字i时，将位置i-1处的数字翻转为负数。
         * 如果位置i-1 上的数字已经为负，则i是出现两次的数字。
         */
        return extracted(nums);
    }

    /**
     * Your runtime beats 70.16 % of java submissions
     * Your memory usage beats 20.54 % of java submissions (49.4 MB)
     * 
     * @param nums
     * @return
     */
    private List<Integer> extracted(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(Math.abs(index + 1));
            nums[index] = -nums[index];
        }
        return res;
    }
}
// @lc code=end
