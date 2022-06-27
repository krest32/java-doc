import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        // 哈希
        // return extracted(nums);

        // 1
        return extracted2(nums);
    }

    private int extracted2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!set.contains(num - 1)) {
                int curNbr = num + 1;
                int curLen = 1;
                while (set.contains(curNbr)) {
                    curLen++;
                    curNbr++;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }

    private int extracted(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int temp = nums[i];
                int flag = 1;
                while (set.contains(temp + 1)) {
                    flag++;
                    temp++;
                }
                num = Math.max(num, flag);
            }
        }
        return num;
    }
}
// @lc code=end
