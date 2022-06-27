/*
 * @lc app=leetcode.cn id=1668 lang=java
 *
 * [1668] 最大重复子字符串
 */

// @lc code=start
class Solution {
    public int maxRepeating(String sequence, String word) {
        // String Api
        return extracted(sequence, word);
    }

    /**
     * 212/212 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 81.58 % of java submissions (39.3 MB)
     * 
     * @param sequence
     * @param word
     * @return
     */
    private int extracted(String sequence, String word) {
        int cnt = 0;
        StringBuilder ans = new StringBuilder(word);
        boolean flag = true;
        while (flag) {
            if (sequence.indexOf(String.valueOf(ans)) >= 0) {
                ans.append(word);
                cnt++;
            } else {
                flag = false;
            }
        }
        return cnt;
    }
}
// @lc code=end
