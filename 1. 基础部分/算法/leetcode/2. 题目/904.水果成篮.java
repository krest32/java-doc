import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=904 lang=java
 *
 * [904] 水果成篮
 */

// @lc code=start
class Solution {
    public int totalFruit(int[] fruits) {
        // 滑动窗口
        return extracted(fruits);

    }

    /**
     * Your runtime beats 88.28 % of java submissions
     * Your memory usage beats 46.3 % of java submissions (48.7 MB)
     * 
     * @param fruits
     * @return
     */
    private int extracted(int[] fruits) {
        int n = fruits.length;
        if (n <= 2)
            return n;
        int ans = 2, left = 0, right = 0;
        int[] freq = new int[n];
        int count = 0;
        while (right < n) {
            freq[fruits[right]]++;
            if (freq[fruits[right]] == 1)
                count++;
            right++;
            while (count > 2) {
                freq[fruits[left]]--;
                if (freq[fruits[left]] == 0)
                    count--;
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}

// @lc code=end
