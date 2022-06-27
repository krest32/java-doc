import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 丢失的数字
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        // 排序
        // return extracted(nums);

        // 哈希
        // return extracted2(nums);

        // 数学
        // return extracted3(nums);

        // 位运算 -- > 最优解
        return extracted4(nums);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 5.49 % of java submissions (42.4 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted4(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        return xor;
    }

    /**
     * Your runtime beats 40.08 % of java submissions
     * Your memory usage beats 42.61 % of java submissions (41.8 MB)
     */
    private int extracted3(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int arrSum = Arrays.stream(nums).sum();
        return total - arrSum;
    }

    /**
     * 
     * Your runtime beats 38.84 % of java submissions
     * Your memory usage beats 43.43 % of java submissions (41.8 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int missing = -1;
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }
        return missing;
    }

    /**
     * 排序
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        // 二分查找法，判断num[i]是否与i相等
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
// @lc code=end
