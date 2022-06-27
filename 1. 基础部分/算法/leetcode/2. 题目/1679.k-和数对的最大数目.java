import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1679 lang=java
 *
 * [1679] K 和数对的最大数目
 */

// @lc code=start
class Solution {
    public int maxOperations(int[] nums, int k) {
        // 排序 + 双指针法
        // return extracted(nums, k);

        // 哈希 --> 反而更慢了
        return extracted2(nums, k);

    }

    /**
     * Your runtime beats 11.63 % of java submissions
     * Your memory usage beats 5.23 % of java submissions (56.9 MB)
     * 
     * @param nums
     * @param k
     * @return
     */
    private int extracted2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (int num : nums) {
            if (num == k - num && map.containsKey(num)
                    && map.get(num) < 2) {
                map.remove(num);
                continue;
            }
            if (map.containsKey(num) && map.containsKey(k - num)) {
                ans++;
                int cnt1 = map.get(num);
                cnt1--;
                if (cnt1 > 0) {
                    map.put(num, cnt1);
                } else {
                    map.remove(num);
                }
                int cnt2 = map.get(k - num);
                cnt2--;
                if (cnt2 > 0) {
                    map.put(k - num, cnt2);
                } else {
                    map.remove(k - num);
                }
            }
        }
        return ans;
    }

    /**
     * Your runtime beats 61.63 % of java submissions
     * Your memory usage beats 39.53 % of java submissions (51.7 MB)
     * 
     * @param nums
     * @param k
     * @return
     */
    private int extracted(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                left++;
                right--;
                ans++;
            } else if (sum > k) {
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }
}
// @lc code=end
