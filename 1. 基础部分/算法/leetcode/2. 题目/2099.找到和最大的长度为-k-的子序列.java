import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=2099 lang=java
 *
 * [2099] 找到和最大的长度为 K 的子序列
 */

// @lc code=start
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // 哈希
        return extracted(nums, k);
    }

    private int[] extracted(int[] nums, int k) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);// 排序
        Map<Integer, Integer> map = new HashMap<>();
        // 哈希表存，因为有重复的 所以进行计数
        for (int i = 0; i < k; i++) {
            int val = copy[nums.length - 1 - i];
            int count = map.getOrDefault(val, 0);
            map.put(val, count + 1);
        }
        int[] res = new int[k];
        int index = 0;
        // 遍历原数组 为了保持原顺序
        for (int num : nums) {
            if (map.containsKey(num)) {
                res[index++] = num;
                int count = map.get(num) - 1;
                if (count == 0)
                    map.remove(num);
                else
                    map.put(num, count);
            }
            if (map.size() == 0)
                return res;
        }
        return res;
    }
}
// @lc code=end
