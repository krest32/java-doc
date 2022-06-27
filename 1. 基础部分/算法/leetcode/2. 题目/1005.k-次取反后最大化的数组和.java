import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 模拟：从小到大修改每个负数
        return extracted(nums, k);
    }

    private int extracted(int[] nums, int k) {
        // 统计每个数字出现的频率
        Map<Integer, Integer> frep = new HashMap<>();
        for (int num : nums) {
            frep.put(num, frep.getOrDefault(num, 0) + 1);
        }
        // 计算和值
        int ans = Arrays.stream(nums).sum();
        // 看是判断是否存在-100~0的负数
        for (int i = -100; i < 0; i++) {
            if (frep.containsKey(i)) {
                int ops = Math.min(k, frep.get(i));
                ans += (-i) * ops * 2;
                frep.put(i, frep.get(i) - ops);
                frep.put(-i, frep.getOrDefault(-i, 0) + ops);
                k -= ops;
                if (k == 0) {
                    break;
                }
            }
        }
        // 如果负数修改完成，开始修改整数
        if (k > 0 && k % 2 == 1 && !frep.containsKey(0)) {
            for (int i = 0; i <= 100; i++) {
                // 修改最小的正数，改为负数即可
                if (frep.containsKey(i)) {
                    ans -= i * 2;
                    break;
                }
            }
        }
        return ans;
    }
}
// @lc code=end
