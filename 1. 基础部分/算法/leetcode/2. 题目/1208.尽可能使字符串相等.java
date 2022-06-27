/*
 * @lc app=leetcode.cn id=1208 lang=java
 *
 * [1208] 尽可能使字符串相等
 */

// @lc code=start
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        // 滑动窗口
        // return extracted(s, t, maxCost);

        // 1
        return extracted2(s, t, maxCost);
    }

    private int extracted2(String s, String t, int maxCost) {
        int len = s.length();
        int[] cost = new int[len];
        for (int i = 0; i < len; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int windowSum = 0;
        int right = 0;
        int left = 0;
        int maxLen = 0;
        while (right < len) {
            windowSum += cost[right];
            while (windowSum > maxCost) {
                windowSum -= cost[left];
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    private int extracted(String s, String t, int maxCost) {
        int n = s.length();
        int[] diff = new int[n];
        // 记录每个字符转变的最小开销
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int maxLength = 0;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += diff[end];
            while (sum > maxCost) {
                sum -= diff[start];
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
}
// @lc code=end
