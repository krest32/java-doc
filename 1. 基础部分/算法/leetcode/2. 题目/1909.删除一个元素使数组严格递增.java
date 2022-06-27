/*
 * @lc app=leetcode.cn id=1909 lang=java
 *
 * [1909] 删除一个元素使数组严格递增
 */

// @lc code=start
class Solution {
    public boolean canBeIncreasing(int[] nums) {
        boolean delete = false;
        int lasti = 0;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur <= nums[lasti]) {
                if (delete) {
                    return false;
                } else {
                    delete = true;
                    if (lasti == 0 || cur > nums[lasti - 1]) {
                        // 别忘了lasti == 0 ，不然越界
                        if (cur < nums[lasti]) {
                            lasti = i;
                        }
                    }
                }
            } else {
                lasti = i;
            }
        }
        return true;
    }
}
// @lc code=end
