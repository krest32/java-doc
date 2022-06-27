import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1512 lang=java
 *
 * [1512] 好数对的数目
 */

// @lc code=start
class Solution {
    public int numIdenticalPairs(int[] nums) {
        // return answer1(nums);
        return answer2(nums);
    }

    /**
     * 暴力统计
     * 
     * @return 数对数目
     */
    int answer1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 组合计数
     * 
     * @param nums
     * @return
     */
    int answer2(int[] nums) {
        // 统计每个数字出现的频率
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        // 计算频率可以构成的对数
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int v = entry.getValue();
            ans += v * (v - 1) / 2;
        }

        return ans;
    }

}
// @lc code=end
