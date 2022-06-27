import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        // 遍历整个数组
        while (i < n) {
            int low = i;
            i++;
            // 跳过不需要关注的元素
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            // 定义高点
            int high = i - 1;
            // 汇总区间元素
            StringBuilder res = new StringBuilder(String.valueOf(nums[low]));
            if (low < high) {
                res.append("->" + String.valueOf(nums[high]));
            }
            // 将 String 添加到List中
            ret.add(res.toString());
        }
        return ret;
    }
}
// @lc code=end
