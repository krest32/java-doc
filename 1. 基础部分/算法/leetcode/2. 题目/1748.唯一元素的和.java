import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1748 lang=java
 *
 * [1748] 唯一元素的和
 */

// @lc code=start
class Solution {
    public int sumOfUnique(int[] nums) {
        // 哈希，一次遍历
        int ans = 0;
        return extracted(nums, ans);
    }

    private int extracted(int[] nums, int ans) {
        Map<Integer, Integer> state = new HashMap<>();
        for (int num : nums) {
            if (!state.containsKey(num)) {
                ans += num;
                state.put(num, 1);
            } else if (state.get(num) == 1) {
                ans -= num;
                state.put(num, 2);
            }
        }
        return ans;
    }
}
// @lc code=end
