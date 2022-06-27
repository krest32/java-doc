import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        // 原地hash
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] = nums[x] + n;
        }

        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] < n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
// @lc code=end
