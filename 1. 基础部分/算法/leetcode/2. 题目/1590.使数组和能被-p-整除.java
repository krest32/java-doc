import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1590 lang=java
 *
 * [1590] 使数组和能被 P 整除
 */

// @lc code=start
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int mod = 0;
        // 判断数组和能够被p整除
        for (int num : nums)
            mod = (mod + num) % p;
        if (mod == 0)
            return 0;
        int res = n;
        int subMod = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            // 求取前缀和对于p的余数
            subMod = (subMod + nums[i]) % p;
            // sub_mod可能比mod要小，为了避免target出现负数，
            // target中多加了一个p
            int target = (subMod - mod + p) % p;
            if (map.containsKey(target)) {
                res = Math.min(res, i - map.get(target));
                // 不能够移除整个数组
                if (res == 1 && res != n) {
                    return res;
                }
            }
            // 对于前缀和数组，用哈希表记录其对p的余数及索引
            map.put(subMod, i);
        }
        if (res == n)
            return -1;
        return res;
    }
}
// @lc code=end
