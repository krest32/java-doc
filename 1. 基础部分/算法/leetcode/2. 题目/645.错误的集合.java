import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=645 lang=java
 *
 * [645] 错误的集合
 */

// @lc code=start
class Solution {
    public int[] findErrorNums(int[] nums) {
        // 排序
        // return extracted(nums);

        // 模拟计数
        return extracted2(nums);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 23.4 % of java submissions (42.9 MB)
     * 
     * @param nums
     * @return
     */
    private int[] extracted2(int[] nums) {
        int n = nums.length;
        int[] cnts = new int[n + 1];
        for (int x : nums)
            cnts[x]++;
        int[] ans = new int[2];
        for (int i = 1; i <= n; i++) {
            if (cnts[i] == 0)
                ans[1] = i;
            if (cnts[i] == 2)
                ans[0] = i;
        }
        return ans;
    }

    private int[] extracted(int[] nums) {
        int[] errorNums = new int[2];
        int n = nums.length;
        Arrays.sort(nums);
        int pre = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            if (cur == pre) {
                errorNums[0] = pre;
            } else if (cur - pre > 1) {
                errorNums[1] = pre + 1;
            }
            pre = cur;
        }
        if (nums[n - 1] != n) {
            errorNums[1] = n;
        }
        return errorNums;
    }
}
// @lc code=end
