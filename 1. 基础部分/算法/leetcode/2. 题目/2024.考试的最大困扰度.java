/*
 * @lc app=leetcode.cn id=2024 lang=java
 *
 * [2024] 考试的最大困扰度
 */

// @lc code=start
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        char[] arr = answerKey.toCharArray();
        int left = 0;
        int right = 0;
        int numT = 0;
        int numF = 0;
        int ans = 0;
        while (right < n) {
            if (arr[right] == 'T') {
                numT++;
            } else {
                numF++;
            }
            while (numT > k && numF > k) {
                if (arr[left] == 'T') {
                    numT--;
                } else {
                    numF--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
// @lc code=end
